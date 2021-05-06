# Installing on Tomcat

```important::
   `Using a Tomcat bundle <../installing-a-liferay-tomcat-bundle.md>`_ or `Docker image <../../../getting-started/starting-with-a-docker-image.md>`_ is the fastest way to get started using Liferay DXP. This article is for users who want to have full control over their Tomcat application server's configuration.

   Review the `Installing a Liferay-Tomcat Bundle <../installing-a-liferay-tomcat-bundle.md>`_ and `Configuring a Database <../configuring-a-database.md>`_ articles before continuing.
```

Installing Liferay DXP on Tomcat requires deploying the DXP WAR file, deploying DXP's dependencies, and configuring Tomcat for DXP.

The simplest and easiest way to accomplish this is by [downloading the Liferay DXP Tomcat](../installing-a-liferay-tomcat-bundle.md) bundle that is created by Liferay and copying the dependencies, scripts, and `ROOT.xml` provided there. You may also opt to download the dependencies and to create/modify their Tomcat scripts and configurations by hand.

In addition to copying dependencies, scripts, and configurations from the Liferay Tomcat bundle files (or manually downloading and configuring), you must also download these files from the [Help Center](https://customer.liferay.com/downloads) (subscription) or from [Liferay Community Downloads](https://www.liferay.com/downloads-community):

* DXP WAR file
* Dependencies ZIP file
* OSGi Dependencies ZIP file

Liferay DXP requires a Java JDK 8 or 11.

```note::
   Please see `the compatibility matrix <https://help.liferay.com/hc/en-us/articles/360049238151>`_ for information on supported JDKs, databases, and environments.  See `JVM Configuration <../../reference/jvm-configuration.md>`_ for recommended JVM settings.
```

Here are the basic steps for installing DXP on Tomcat:

1. [Installing Dependencies](#installing-dependencies)
1. [Configuring Tomcat](#configuring-tomcat)
1. [Database Configuration](#database-configuration)
1. [Mail Configuration](#mail-configuration)
1. [Deploying the DXP WAR](#deploying-DXP)

The Tomcat server parent folder is [*Liferay Home*](../../reference/liferay-home.md). `$TOMCAT_HOME` refers to Tomcat server folder. It is usually named `tomcat-[version]` or `apache-tomcat-[version]`.

## Installing Dependencies

DXP depends on many JARs included in DXP Tomcat bundle. Some of the bundle's JARs are not strictly required but can still be useful. If you're not using a Tomcat bundle, you'll use the Liferay JARs in the *Dependencies* archive and the *OSGi Dependencies* archive you downloaded and third-party JARs as described below.

1. Unzip the Dependencies ZIP file contents in the `$TOMCAT_HOME/lib/ext` folder (create this folder if it doesn't exist).
1. Unzip the OSGi Dependencies ZIP file contents in the `[Liferay Home]/osgi` folder (create this folder if it doesn't exist).
1. The DXP 7.4+ WAR includes drivers for MariaDB, MySQL, and PostgreSQL. Earlier DXP WARs don't have them. If your DXP WAR doesn't have the driver you want, download your database vendor's JDBC JAR file to the `$TOMCAT_HOME/lib/ext` folder. Please see the [compatibility matrix](https://help.liferay.com/hc/en-us/articles/360049238151) for a list of supported databases.

```note::
   A Hypersonic database is bundled with Portal/DXP and is useful for testing purposes. **Do not** use HSQL for production instances.
```

## Configuring Tomcat

Configuring Tomcat to run DXP includes:

* Setting environment variables
* Specifying a web application context for DXP
* Setting properties and descriptors

Here are the steps:

1. Copy the `setenv.bat`, `setenv.sh`,  `startup.bat`, `startup.sh`, `shutdown.bat`, and `shutdown.sh` files from a DXP bundle to the `$CATALINA_BASE/bin` folder. Otherwise, create the  `setenv.bat` and `setenv.sh` scripts.

    The scripts set JVM options for Catalina, which is Tomcat's servlet container. Among these options is the location of the Java runtime environment. If this environment is not available on the server globally, set its location in in these files so Tomcat can run. Do this by pointing the `JAVA_HOME` environment variable to a DXP-supported JRE:

    ```bash
    export JAVA_HOME=/usr/lib/jvm/java-8-jdk
    export PATH=$JAVA_HOME/bin:$PATH
    ```

    Then configure Catalina's JVM options to support DXP.

    ```bash
    CATALINA_OPTS="$CATALINA_OPTS -Dfile.encoding=UTF-8 -Djava.net.preferIPv4Stack=true -Dorg.apache.catalina.loader.WebappClassLoader.ENABLE_CLEAR_REFERENCES=false -Duser.timezone=GMT -Xms2560m -Xmx2560m -XX:MaxMetaspaceSize=512m"
    ```

    This does the following:

    1. Sets the file encoding to UTF-8.
    1. Prefers an IPv4 stack over IPv6.
    1. Prevents Tomcat from working around garbage collection bugs relating to static or final fields (these bugs don't exist in DXP and working around them causes problems with the logging system).
    1. Sets the time zone to GMT
    1. Gives the JVM 2GB of RAM
    1. Limits Metaspace to 512MB.

    ```important::
       DXP requires that the application server JVM use the GMT time zone and UTF-8 file encoding.
    ```

    ```note::
       On JDK 11, it's recommended to add this JVM argument to display four-digit years: ``-Djava.locale.providers=JRE,COMPAT,CLDR``
    ```

    After installation, these configurations (including these JVM options) can be further tuned for improved performance.

2. If you have a DXP Tomcat bundle, copy its `$CATALINA_BASE/conf/Catalina/localhost/ROOT.xml` file to the corresponding location in the application server. Create the file path if it doesn't exist and the `ROOT.xml` file.

    The `ROOT.xml` file specifies a web application context for DXP which looks like this:

    ```xml
    <Context crossContext="true" path="">

        <!--
        Uncomment the following to disable persistent sessions across reboots.
        -->

        <!--<Manager pathname="" />-->

        <!--
        Uncomment the following to not use sessions. See the property
        "session.disabled" in portal.properties.
        -->

        <!--<Manager className="com.liferay.support.tomcat.session.SessionLessManagerBase" />-->

        <Resources>
            <PreResources
                base="${catalina.base}/lib/ext/portal"
                className="com.liferay.support.tomcat.webresources.ExtResourceSet"
                webAppMount="/WEB-INF/lib"
            />
        </Resources>
    </Context>
    ```

     Setting `crossContext="true"` lets multiple web applications use the same class loader. This configuration includes commented instructions and tags for disabling persistent sessions and disabling sessions entirely.

3. Provide Catalina access to the JARs in `$CATALINA_BASE/lib/ext` by opening your `$CATALINA_BASE/conf/catalina.properties` file and appending this value to the `common.loader` property:

    ```
    ,"${catalina.home}/lib/ext/global","${catalina.home}/lib/ext/global/*.jar","${catalina.home}/lib/ext","${catalina.home}/lib/ext/*.jar"
    ```

4. Make sure to use UTF-8 URI encoding consistently. Copy the `$CATALINA_BASE/conf/server.xml` file from a Tomcat bundle to the server. Otherwise, open the `$CATALINA_BASE/conf/server.xml` file and add the attribute `URIEncoding="UTF-8"` to HTTP and AJP connectors that use `redirectPort=8443`. Here are examples:

    Old:

    ```xml
    <Connector port="8080" protocol="HTTP/1.1" connectionTimeout="20000" redirectPort="8443" />
    ```

    New:

    ```xml
    <Connector port="8080" protocol="HTTP/1.1" connectionTimeout="20000" redirectPort="8443" URIEncoding="UTF-8" />
    ```

    Old:

    ```xml
    <Connector port="8009" protocol="AJP/1.3" redirectPort="8443" />
    ```

    New:

    ```xml
    <Connector port="8009" protocol="AJP/1.3" redirectPort="8443" URIEncoding="UTF-8" />
    ```

5. Refrain from writing access logs (optional) by commenting out the access log `Valve` element in `$CATALINA_BASE/conf/server.xml`. It's commented out here:

    ```xml
    <!-- <Valve className="org.apache.catalina.valves.AccessLogValve"
           directory="logs"
           prefix="localhost_access_log" suffix=".txt"
           pattern="%h %l %u %t &quot;%r&quot; %s %b" /> -->
    ```

6. Optionally, set the following log levels in the `$CATALINA_HOME/conf/logging.properties` file:

    ```properties
    org.apache.catalina.startup.Catalina.level=INFO
    org.apache.catalina.startup.ClassLoaderFactory.level=SEVERE
    org.apache.catalina.startup.VersionLoggerListener.level=WARNING
    org.apache.level=WARNING
    ```

7. In `$CATALINA_HOME/conf/web.xml`, set the JSP compiler to Java 8 and set DXP's `TagHandlerPool` class to manage the JSP tag pool. Add the following elements above the `jsp` servlet element's `<load-on-startup>` element.

    ```xml
    <init-param>
        <param-name>compilerSourceVM</param-name>
        <param-value>1.8</param-value>
    </init-param>
    <init-param>
        <param-name>compilerTargetVM</param-name>
        <param-value>1.8</param-value>
    </init-param>
    <init-param>
        <param-name>tagpoolClassName</param-name>
        <param-value>com.liferay.support.tomcat.jasper.runtime.TagHandlerPool</param-value>
    </init-param>
    ```

8. In `$CATALINA_HOME/conf/web.xml`, specify whether the application server should look for extra metadata, such as annotations in the application's JARs and classes. Setting `web-app` element's attribute `metadata-complete="true"` tells the application server there's no extra metadata. This configuration improves application server startup performance. The default is to check for extra metadata.

9. If using Unix, Linux, or Mac OS, make the shell scripts in your `$CATALINA_HOME/bin` and `$CATALINA_BASE/bin` folders executable by running this command in each folder:

    ```bash
    chmod a+x *.sh
    ```

**Checkpoint:**

1. The file encoding, user time-zone, and preferred protocol stack are set in the `setenv.sh`.
1. The default memory available and Metaspace limit are set.
1. `$CATALINA_BASE/conf/Catalina/localhost/ROOT.xml` declares the web application context.
1. The `common.loader` property in `$CATALINA_BASE/conf/catalina.properties`grants Catalina access to the JARs in `$CATALINA_BASE/lib/ext`.
1. `$CATALINA_BASE/conf/server.xml` sets UTF-8 encoding.
1. `$CATALINA_BASE/conf/server.xml` does not declare any valve for writing host access logs. *(optional)*
1. `$CATALINA_HOME/conf/logging.properties` sets the desired log levels.
1. `$CATALINA_HOME/conf/web.xml` sets the tag handler pool and sets Java 8 as the JSP compiler.
1. `$CATALINA_HOME/conf/web.xml` specifies for the application server to refrain from looking for extra metadata. *(optional)*
1. The scripts in Tomcat's `bin` folders are executable.

The application server is configured to run DXP.

## Database Configuration

DXP contains a built-in Hypersonic database which is great for demonstration purposes but **should not be used in production**. For production, use a full-featured, supported RDBMS. See [Configure a Database](../configuring-a-database.md) to set up your database.

Liferay DXP can connect with your database using DXP's built-in data source (recommended) or using a data source you create on your app server.

To configure DXP's built-in data source with your database when you run DXP for the first time, you can use the [Setup Wizard](../../../getting-started/using-the-setup-wizard.md). Or you can configure the data source in a [`portal-ext.properties` file](../../reference/portal-properties.md) based on the [Database Template](../../reference/database-templates.md) for your database.

Otherwise, you can configure the data source in Tomcat.

### Configuring the Tomcat Data Source

1. Make sure the database server is installed and working. If it's installed on a different machine, verify that DXP machine can access it.

1. Get the JDBC JAR from your DXP WAR (7.4+) or from the database vendor, and copy it to the `$TOMCAT_HOME/lib/ext` folder.

1. Open `$CATALINA_BASE/conf/Catalina/localhost/ROOT.xml` and add data source as a `Resource` in the web application `Context`:

    ```xml
    <Context...>
        ...
        <Resource
            name="jdbc/LiferayPool"
            auth="Container"
            type="javax.sql.DataSource"
            driverClassName="[place the driver name here]"
            url="[place the URL to your database here]"
            username="[place your user name here]"
            password="[place your password here]"
            maxTotal="100"
            maxIdle="30"
            maxWaitMillis="10000"
        />
    </Context>
    ```

    Make sure to replace the database URL, user name, and password with the appropriate values.

1. In a `portal-ext.properties` file in **[Liferay_Home]**, specify the data source:

    ```properties
    jdbc.default.jndi.name=jdbc/LiferayPool
    ```

The data source is configured.

## Mail Configuration

The easiest way to configure mail is to use the DXP [built-in mail session](../../setting-up-liferay/configuring-mail/connecting-to-a-mail-server.md). If you use the built-in mail session, you may skip this section.

If you want to use Tomcat to manage the mail session, follow these steps:

1. Open `$CATALINA_BASE/conf/Catalina/localhost/ROOT.xml` and the your mail session as a `Resource` in the web application `Context`. Replace the example mail session values with your own.

    ```xml
    <Context...>
        ...
        <Resource
            name="mail/MailSession"
            auth="Container"
            type="javax.mail.Session"
            mail.pop3.host="[place POP mail host here]"
            mail.pop3.port="110"
            mail.smtp.host="[place SMTP mail host here]"
            mail.smtp.port="465"
            mail.smtp.user="[place user name here]"
            mail.smtp.password="[place password here]"
            mail.smtp.auth="true"
            mail.smtp.starttls.enable="true"
            mail.smtp.socketFactory.class="javax.net.ssl.SSLSocketFactory"
            mail.imap.host="[place IMAP mail host here]"
            mail.imap.port="993"
            mail.transport.protocol="smtp"
            mail.store.protocol="imap"
        />
    </Context>
    ```

1. In the `portal-ext.properties` file in Liferay Home, enter the mail session values:

    ```properties
    mail.session.jndi.name=mail/MailSession
    ```

The mail session for Tomcat has been configured.

## Deploying DXP

1. If this is manual installation on a clean Tomcat server, delete the contents of the `$CATALINA_BASE/webapps/ROOT` folder. This removes the default Tomcat home page.
1. Extract the DXP `.war` file contents to `$CATALINA_BASE/webapps/ROOT`.
1. Start Tomcat by navigating to `$CATALINA_HOME/bin` and executing `./startup.sh`. Alternatively, execute `./catalina.sh run` to tail DXP's log file. The log audits startup activities and is useful for debugging deployment.

Congratulations! You're running DXP on Tomcat.

## Next Steps

You can [sign in as your administrator user](../../../getting-started/introduction-to-the-admin-account.md) and start [building a solution on DXP](../../../building_solutions_on_dxp.html. Or you can explore [additional Liferay DXP setup](../../setting_up_liferay.html) topics:

* [Installing the Marketplace Plugin](../../../system-administration/installing-and-managing-apps/getting-started/using-marketplace.md#appendix-installing-the-marketplace-plugin)
* [Accessing Plugins During a Trial Period](../../../system-administration/installing-and-managing-apps/installing-apps/accessing-ee-plugins-during-a-trial-period.md)
* [Installing a Search Engine](../../../using-search/installing-and-upgrading-a-search-engine/installing-a-search-engine.md)
* [Securing Liferay DXP](../../securing-liferay/securing-liferay.md)
* [Clustering for High Availability](../../setting-up-liferay/clustering-for-high-availability/clustering-for-high-availability.md)
