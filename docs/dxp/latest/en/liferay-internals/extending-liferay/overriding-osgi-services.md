# Overriding OSGi Services

Liferay's OSGi container is a dynamic environment in which services can be added, removed, or overridden as needed. This framework registers Liferay components with the OSGi service registry, each with their own availability, ranking, and attributes. Together, these details determine how components bind to the services they reference.

To override an OSGi service, you'll follow these steps:

1. Identify the service you want to override, as well as any components that reference it.

1. Gather the following service details.

   * **Service Type**: the interface implemented by the service you're overriding

   * **Service's Class Name**: the existing service's full name

1. If applicable, gather the following details for components that reference the service.

   * **Component Name**: the full name of a component that references the service you're overriding

   * **Reference Name**: the field name that references to the target service

   * **Reference Policy**: whether the reference is `static` or `dynamic`

   * **Reference Policy-Option**: whether the `policy-option` is `greedy` or `reluctant`

   * **Cardinality**: the number of service instances to which the reference can and must bind

   Together, a service's [Reference Policy](https://docs.osgi.org/javadoc/r5/enterprise/org/osgi/service/component/annotations/ReferencePolicy.html), [Reference Policy Option](https://docs.osgi.org/javadoc/r5/enterprise/org/osgi/service/component/annotations/ReferencePolicyOption.html), and [Cardinality](https://docs.osgi.org/javadoc/r5/enterprise/org/osgi/service/component/annotations/ReferenceCardinality.html) determine a component's conditions for adopting new services.

1. Create a new service that uses the same interface implemented by the service you're overriding.

1. Give your service a higher ranking than the service it's overriding.

1. (Optional) If necessary, reference and invoke the service you're overriding in your service.

The [sample modules](./liferay-s1j6.zip) demonstrate how to override an OSGi service. These modules include an API for defining a new OSGi service type, an initial implementation of that type, and a generic portlet that references the initial implementation. Also included are alternate implementations of the API to demonstrate how to override the initial implementation.

## Deploy Sample Modules for Overriding

1. Start a new [Liferay Docker container](../../installation-and-upgrades/installing-liferay/using-liferay-docker-images/docker-container-basics.md).

   ```bash
   docker run -it -p 8080:8080 [$LIFERAY_LEARN_DXP_DOCKER_IMAGE$]
   ```

1. Download and unzip the example modules.

   ```bash
   curl https://learn.liferay.com/dxp/7.x/en/liferay-internals/extending-liferay/liferay-s1j6.zip -O
   ```

   ```bash
   unzip liferay-s1j6.zip -d liferay-s1j6
   ```

1. Run the following `gradlew` command from the `s1j6-api`, `s1j6-able-impl`, and `s1j6-web` subfolders to build and deploy a JAR file for each module to your new Docker container:

   ```bash
   ../gradlew deploy -Ddeploy.docker.container.id=$(docker ps -lq)
   ```

   Each module's JAR is generated in its `build/libs` folder (e.g., `s1j6-api/build/libs/com.acme.s1j6.api-1.0.0.jar`).

   Log messages indicate when Liferay begins processing and successfully starts each module. These logs also provide each service's bundle id.

   ```
   STARTED com.acme.s1j6.api_1.0.0 [1356]
   STARTED com.acme.s1j6.able.impl_1.0.0 [1357]
   STARTED com.acme.s1j6.web_1.0.0 [1358]
   ```

1. Confirm the modules have successfully deployed via the Gogo Shell.

   ```shell
   lb | grep -i "s1j6"
   ```

   If successful, the output reads as follows:

   ```
   1356|Active     |   15|Acme S1J6 API (1.0.0)|1.0.0
   1357|Active     |   15|Acme S1J6 Able Implementation (1.0.0)|1.0.0
   1358|Active     |   15|Acme S1J6 Web (1.0.0)|1.0.0
   true
   ```

The provided `api` defines an OSGi service type that is implemented by the `able.impl` module, which in turn is used by the provided `portlet`. Now that everything's deployed, you can experiment with how overrides work.

## Gathering OSGi Service and Reference Details

Once you've identified the service you want to override, use the `scr:info` Gogo Shell command to gather its essential service and reference details. In this example, we want to override the `able.impl` service.

To gather its service details, run the following command:

```shell
scr:info com.acme.s1j6.able.internal.S1J6AbleImpl
```

```
Component Description: com.acme.s1j6.able.internal.S1J6AbleImpl
===============================================================
Class:         com.acme.s1j6.able.internal.S1J6AbleImpl
Bundle:        1357 (com.acme.s1j6.able.impl:1.0.0)
[...]

Component Configuration Id: 8337
--------------------------------
State:        ACTIVE
Service:      17776 [com.acme.s1j6.S1J6]
    Used by bundle 1358 (com.acme.s1j6.web:1.0.0)
Config Props: (2 entries)
  component.id = 8337
  component.name = com.acme.s1j6.able.internal.S1J6AbleImpl
References:   (total 0)
```

This abbreviated output lists the following service details for `S1J6AbleImpl`:

* **Service Type**: `S1J6AbleImpl` implements the `S1J6` interface,`com.acme.s1j6.S1J6`.

* **Service's Class Name**: The service's full name is `com.acme.s1j6.able.internal.S1J6AbleImpl`.

It also indicates that the service is used by a component within the `com.acme.s1j6.web:1.0.0` bundle. To view the component's reference configuration details, run the `scr:info` command with the component's full name:

```shell
scr:info com.acme.s1j6.web.internal.portlet.S1J6Portlet
```

```
Component Description: com.acme.s1j6.web.internal.portlet.S1J6Portlet
=====================================================================
Class:         com.acme.s1j6.web.internal.portlet.S1J6Portlet
Bundle:        1358 (com.acme.s1j6.web:1.0.0)
[...]

Component Configuration Id: 8338
--------------------------------
[...]
References:   (total 1)
  - _s1J6: com.acme.s1j6.S1J6 SATISFIED 1..1 static
    target=(*) scope=bundle (1 binding):
    * Bound to [17776] from bundle 1357 (com.acme.s1j6.able.impl:1.0.0)
```

This abbreviated output lists the following reference configuration details:

**Reference Name**: The name of the field that references the `S1J6AbleImpl` service is `_s1J6`.

**Reference Policy**: The component's reference policy is `static` (default).

**Reference Policy-Option**: Since no `policy-option` is explicitly defined, it uses the default configuration, `reluctant`.

**Cardinality**: Its Cardinality is both mandatory and unary (i.e., `1..1`).

While some reference configurations automatically bind to a new or higher ranking service, some require a server restart. Since `S1J6Portlet`'s reference configuration is static, reluctant, mandatory, and unary, a server restart is required before it binds to a new, higher ranking service. See [OSGi documentation](http://docs.osgi.org/specification/osgi.cmpn/7.0.0/service.component.html#service.component-policy.option.action) for more information about how different reference configurations affect a component's behavior when new or higher ranking services become available.

## Creating an OSGi Service with the Gathered Details

Once you've gathered the requisite service and reference details, you can use them to create a custom service for overriding and invoking the target service.

1. Declare the service a component within the OSGi framework using the `@Component` annotation.

1. Implement the same interface as the target OSGi service and identify its `service` type within the `@Component` annotation.

1. Override the interface's methods.

1. Include the `service.ranking:Integer` property within the `@Component` annotation. Ensure its ranking is higher than the existing service.

1. (Optional) Reference the existing service's `component.name` to invoke it.

The sample `S1J6BakerImpl` module is provided to override `S1J6AbleImpl`.

```literalinclude:: overriding-osgi-services/resources/liferay-s1j6.zip/s1j6-baker-impl/src/main/java/com/acme/s1j6/baker/internal/S1J6BakerImpl.java
   :language: java
   :lines: 8-22
```

Here, `S1J6BakerImpl` implements the same service type as `S1J6AbleImpl` (i.e., `com.acme.s1j6.S1J6`) and includes the necessary `@Component` annotation, `service` attribute, and `service.ranking` property. It also references the existing service (i.e., `component.name=com.acme.s1j6.able.internal.S1J6AbleImpl`) and delegates to it as part of overriding the interface's method. The sample modules also include two other S1J6 implementations for overriding `S1J6AbleImpl` and then `S1J6BakerImpl`.

In total, the included implementations have the following rankings:

* `S1J6AbleImpl`: No ranking (defaults to 0)
* `S1J6BakerImpl`: 100
* `S1J6CharlieImpl`: 101
* `S1J6DogImpl`: 101

When deployed, the highest ranking service takes priority and is bound to `S1J6Portlet` after a Liferay server restart. If more than one service has the same ranking, the first service registered takes priority. Lower ranking services are ignored.

## Deploy the Overriding Module and Config File

Follow these steps to deploy `S1J6BakerImpl`, `S1J6CharlieImpl`, and `S1J6DogImpl`:

1. Open the `s1j6-baker-impl` folder in your console.

1. Run the following `gradlew` command to build and deploy a JAR file for the module to the Docker container:

   ```bash
   ../gradlew deploy -Ddeploy.docker.container.id=$(docker ps -lq)
   ```

   Log messages indicate when Liferay begins processing and successfully starts the module along with its bundle ID.

   ```
   STARTED com.acme.s1j6.baker_1.0.0 [1359]
   ```

1. Since `S1J6Portlet`'s reference configuration is static, reluctant, mandatory, and unary, restart the Liferay server to ensure `S1J6Portlet` binds to `S1J6BakerImpl`.

1. Confirm `S1J6BakerImpl` has successfully deployed and bound to your instance via the Gogo Shell.

   ```shell
   scr:info com.acme.s1j6.web.internal.portlet.S1J6Portlet
   ```

   If successful, `S1J6Portlet` is bound to `S1J6BakerImpl`, since it outranks `S1J6AbleImpl`.

   ```
   References:   (total 1)
     - _s1J6: com.acme.s1j6.S1J6 SATISFIED 1..1 static
       target=(*) scope=bundle (1 binding):
       * Bound to [3248] from bundle 1359 (com.acme.s1j6.baker.impl:1.0.0)
   ```

1. Deploy `S1J6CharlieImpl` and `S1J6DogImpl` at the same time to the Docker container.

   ```
   STARTED com.acme.s1j6.charlie_1.0.0 [1360]
   STARTED com.acme.s1j6.dog_1.0.0 [1361]
   ```

1. Restart the Liferay server.

1. Confirm both `S1J6CharlieImpl` and `S1J6DogImpl` have successfully deployed to your instance via the Gogo Shell.

   ```shell
   lb -s | grep -i "s1j6"
   ```

   ```
   1356|Active     |   15|com.acme.s1j6.api (1.0.0)|1.0.0
   1357|Active     |   15|com.acme.s1j6.able.impl (1.0.0)|1.0.0
   1358|Active     |   15|com.acme.s1j6.web (1.0.0)|1.0.0
   1359|Active     |   15|com.acme.s1j6.baker.impl (1.0.0)|1.0.0
   1360|Active     |   15|com.acme.s1j6.charlie.impl (1.0.0)|1.0.0
   1361|Active     |   15|com.acme.s1j6.dog.impl (1.0.0)|1.0.0
   ```

1. Verify which service is bound to `S1J6Portlet`.

   ```shell
   scr:info com.acme.s1j6.web.internal.portlet.S1J6Portlet
   ```

   ```
   References:   (total 1)
     - _s1J6: com.acme.s1j6.S1J6 SATISFIED 1..1 static
       target=(*) scope=bundle (1 binding):
       * Bound to [3249] from bundle 1360 (com.acme.s1j6.charlie.impl:1.0.0)
   ```

   Since both `S1J6CharlieImpl` and `S1J6DogImpl` have the same ranking, the service that's registered first takes priority and is bound to `S1J6Portlet`.

## Additional Information

* [Module Projects](../fundamentals/module-projects.md)
* [Using an OSGi Service](../fundamentals/using-an-osgi-service.md)
* [APIs as OSGi Services](../fundamentals/apis-as-osgi-services.md)
