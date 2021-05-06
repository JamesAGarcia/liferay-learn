# System Properties

DXP runs in the application server's JVM. System properties can be passed directly to the JVM as arguments to `java` in the format `-D[name1]=[value1]` or can be loaded using DXP System Properties files. System properties differ from [Portal Properties](./portal-properties.md) because they're available to the application server and all of its applications.

Your application server's prescribed script is the safest place to add/modify system properties. It can be used to centralize the system properties. Passing all properties in as JVM arguments eliminates timing issues by setting all properties at application server startup. The application server, DXP, and all other web applications can use the properties immediately.

DXP uses the [`portal-impl.jar/system.properties`](https://docs.liferay.com/dxp/portal/7.3-latest/propertiesdoc/system.properties.html) file, however, as a convenience to set required properties. The `system.properties` file can be extended or overridden using a `system-ext.properties` file. System properties files are loaded by the Portal application class loader after application server startup. Here are some functionalities that DXP configures using system properties:

* File encoding
* Logging
* Default XML parser configuration
* JAXB context factory
* Enabling JRuby native extensions

DXP uses System Properties files in these ways:

* DXP _extends_ properties using new properties in `system.properties` (and in `system-ext.properties`), unless the system property `system.properties.set` is `false`
* DXP _overrides_ properties using new values in `system.properties` (and in `system-ext.properties`), unless the system property `system.properties.set.override` is `false`.

```warning::
   Setting or reseting system properties after application server startup has risks:

   * If permissions are enabled on the application server, they may forbid changing system values.
   * System properties are treated as immutable. Another process on the application server can conceivably cache an initial property value before DXP resets the value. In such a case, the system attempts to operate with different values for the same property.
```

Here both ways of specifying system properties are demonstrated:

* [Setting System Properties Directly](#setting-system-properties-directly)
* [Using a `system-ext.properties` File](#using-a-system-ext-properties-file)

## Setting System Properties Directly

An application server's prescribed script for setting system properties is the recommended place to add and modify properties:

1. Disable using `system.properties` and `system-ext.properties` files by setting the following system properties as JVM arguments in the application server script:

    ```
    -Dsystem.properties.set=false -Dsystem.properties.set.override=false
    ```

1. Add each new property as JVM argument using the following format:

    ```
    -D[name]=[value]
    ```

1. Modify any existing properties.

1. Restart the application server.

The application server and DXP are using the new system properties.

## Using a `system-ext.properties` File

If you want to use DXP's `system.properties` file and you want to extend/override system properties, use a `system-ext.properties` file. Here are the steps:

1. Stop the application server.

1. Add your properties to a file called `system-ext.properties`.

1. Add the `system-ext.properties` file to DXP's classpath. Since DXP's `WEB-INF/classes` folder is on the classpath, you can add the `system-ext.properties` file to that folder. Here are two ways to add it:

    If DXP installs to your application server as an exploded web application, add `system-ext.properties` to the DXP application's `WEB-INF/classes` folder.

    If DXP installs to your application server as a WAR file, extract the WAR file contents and add the `system-ext.properties` file to the `WEB-INF/classes` folder. Then repackage the contents as a WAR file.

1. Start the application server.

1. Deploy the DXP web application. For more information, please see the instructions for [installing on your application server](../installing-liferay/installing_liferay_on_an_application_server.html).

Liferay DXP handles system properties in a flexible way, leaving you free to configure your system as best suits you.

## Additional Information

* [Portal Properties](./portal-properties.md)