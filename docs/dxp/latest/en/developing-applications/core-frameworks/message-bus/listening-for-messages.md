# Listening for Messages

You can listen for messages sent to any registered Message Bus destination, whether it's built-in to DXP/Portal, defined by third-parties, or created by you. Messages sent to the same destination typically have something in common, such as a similar event type or topic. Here you'll deploy a class that listens for messages received at a destination called `DestinationNames.DOCUMENT_LIBRARY_PDF_PROCESSOR`. Documents and Media sends a message to this destination after processing every uploaded PDF file.

## Run the Example Message Listener

1.  Start the Liferay Docker image:

    ```bash
    docker run -it -p 8080:8080 [$LIFERAY_LEARN_DXP_DOCKER_IMAGE$]
    ```

1. After DXP/Portal initializes, visit it with your browser at `http://localhost:8080`.

1. Sign in using the default credentials:

    **User Name:** `test@liferay.com`

    **Password:** `test`

1. Download and unzip the [example project](dxp/latest/en/developing-applications/core-frameworks/message-bus/liferay-w3a4.zip):

    ```bash
    curl https://learn.liferay.com/dxp/latest/en/developing-applications/core-frameworks/message-bus/liferay-w3a4.zip -O
    ```

    ```bash
    unzip liferay-w3a4.zip
    ```

1. Build and deploy the project module.

    ```bash
    cd liferay-w3a4
    ```

    ```bash
    ./gradlew deploy -Ddeploy.docker.container.id=$(docker ps -lq)
    ```

    ```note::
       This command is the same as copying the compiled module JAR to ``/opt/liferay/osgi/modules`` on the Docker container.
    ```

1. Confirm the deployment in the Liferay Docker container console.

    ```bash
    STARTED com.acme.w3a4.impl_1.0.0 [2177]
    ```

1. In the UI, [upload a PDF file](../../../content-authoring-and-management/documents-and-media/uploading-and-managing/uploading-files.md) to Documents and Media.

After Documents and Media completes generating the PDF file preview, it sends a message to the destination where the example project's `MessageListener` is listening. The Message Bus relays the message to all `MessageListener`'s registered with the destination. On receiving the relayed message, the project's `MessageListener` logs the message's payload and destination.

```bash
[liferay/document_library_pdf_processor-2][W3A4MessageListener:22] Received message payload [Ljava.lang.Object;@6df886c1 at destination liferay/document_library_pdf_processor
```

Here's how it works. 

## Determine the Destination

Message destinations are referenced by their names. APIs specify destination names. For example, the [`DestinationNames`](https://github.com/liferay/liferay-portal/blob/[$LIFERAY_LEARN_PORTAL_GIT_TAG$]/portal-kernel/src/com/liferay/portal/kernel/messaging/DestinationNames.java) class lists Liferay's built-in destinations. The example `MessageListener` listens for messages sent to the Liferay destination named by the following `String` constant:

```java
DestinationNames.DOCUMENT_LIBRARY_PDF_PROCESSOR
```

Search Liferay's `*DestinationNames` classes in the [source code](https://github.com/liferay/liferay-portal/tree/[$LIFERAY_LEARN_PORTAL_GIT_TAG$]) or search other APIs for destinations to which you can add listeners. You'll specify the destination name in your message listener.

## Implement the `MessageListener` Interface

In the class where you want to receive messages, implement the [`MessageListener`](https://github.com/liferay/liferay-portal/blob/[$LIFERAY_LEARN_PORTAL_GIT_TAG$]/portal-kernel/src/com/liferay/portal/kernel/messaging/MessageListener.java) interface. 

```literalinclude:: ./listening-for-messages/resources/liferay-w3a4.zip/w3a4-impl/src/main/java/com/acme/w3a4/internal/messaging/W3A4MessageListener.java
   :language: java
   :lines: 15
```

Override the `receive` method with logic for processing messages. Here's the example `receive` method implementation:

```literalinclude:: ./listening-for-messages/resources/liferay-w3a4.zip/w3a4-impl/src/main/java/com/acme/w3a4/internal/messaging/W3A4MessageListener.java
   :dedent: 1
   :language: java
   :lines: 17-29
```

The above implementation logs the message payload and destination name. See the [`Message`](https://github.com/liferay/liferay-portal/blob/[$LIFERAY_LEARN_PORTAL_GIT_TAG$]/portal-kernel/src/com/liferay/portal/kernel/messaging/MessageListener.java) class for details on its other methods.

## Register Your MessageListener With the Destination

Use a `Component` annotation to register your class to listen for messages at the desired destination. For example,

```literalinclude:: ./listening-for-messages/resources/liferay-w3a4.zip/w3a4-impl/src/main/java/com/acme/w3a4/internal/messaging/W3A4MessageListener.java
   :language: java
   :lines: 11-15
```

The above annotation registers the class as a `MessageListener` service component for receiving messages at a destination named `DestinationNames.DOCUMENT_LIBRARY_PDF_PROCESSOR`.

Set your component's `destination.name` property value to your destination's name.

When you deploy your project, the OSGi Runtime registers your `MessageListener` with the destination. Your `MessageListener` now receives messages sent to the destination.

## Additional Information

* [Message Bus](../message_bus.html)
