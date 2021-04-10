# Auditing Portlet Activity with Portlet Filters

Portlet filters provide a way to add custom functionality to portlets by intercepting requests and responses at the start of each [portlet request processing phase](https://github.com/sez11a/liferay-learn/pull/215/files). This makes them useful for auditing portlet activities during its render, action, event, and resource serving phases.

Follow these steps to create portlet filters for auditing portlet activities:

1. Identify the target portlet by its full name (e.g., `com_liferay_blogs_web_portlet_BlogsPortlet`).

1. Determine the portlet phase you want to audit, and implement the corresponding portlet filter interface from the [`javax.portlet.filter`](http://docs.liferay.com/portlet-api/3.0/javadocs/javax/portlet/filter/package-summary.html) package.

   * Action Phase - [`ActionFilter`](http://docs.liferay.com/portlet-api/3.0/javadocs/javax/portlet/filter/ActionFilter.html)
   * Event Phase - [`EventFilter`](http://docs.liferay.com/portlet-api/3.0/javadocs/javax/portlet/filter/EventFilter.html)
   * Render Phase - [`RenderFilter`](http://docs.liferay.com/portlet-api/3.0/javadocs/javax/portlet/filter/RenderFilter.html)
   * Resource Serving Phase - [`ResourceFilter`](http://docs.liferay.com/portlet-api/3.0/javadocs/javax/portlet/filter/ResourceFilter.html)

   See [Portlets](../../../developing-applications/developing-a-java-web-application/portlets.md) for more information about each portlet phase.

1. Declare the portlet filter a Component within the OSGi framework using the `@Component` annotation, and identify it as a `PortletFilter.class` service.

   ```note::
      Portlet filters are `OSGi Declarative Service (DS) Component <https://enroute.osgi.org/FAQ/300-declarative-services.html>`_. Filters can also be applied to a portlet using a ``portlet.xml`` descriptor or a ``@PortletLifecycleFilter`` annotation. See Portlet 3.0 Specification for details.
   ```
   <!--TASK: Reconsider admonition link-->
1. Enter the following properties into the `@Component` declaration.

   * `"javax.portlet.name=[portlet_Name]"`: This property sets the filter's target portlet.
   * `"service.ranking:Integer=100"`: This property sets the filter's ranking, with the higher integers executing first. Ensure the filter starts up at the beginning of the filter chain by assigning it the highest ranking.

1. Override the filter's `doFilter` method to audit the desired aspects of the portlet phase.

The following tutorial uses a `RenderFilter` to audit the render phase for the Blogs portlet.

## Deploy the Sample Portlet Filter

Follow these steps to download, build, and deploy the sample Portlet Filter to a new docker container:

1. Start a new [Liferay Docker container](../../installation-and-upgrades/installing-liferay/using-liferay-docker-images/docker-container-basics.md).

   ```bash
   docker run -it -p 8080:8080 [$LIFERAY_LEARN_DXP_DOCKER_IMAGE$]
   ```

1. Download and unzip the example module.

   ```bash
   curl https://learn.liferay.com/dxp/7.x/en/liferay-internals/extending-liferay/liferay-b4k8.zip -O
   ```
   <!--TASK: fix following path once 7.x is removed-->
   ```bash
   unzip liferay-b4k8.zip -d liferay-b4k8
   ```

1. Run the following `gradlew` command to build the JAR file and deploy it to your new Docker container:

   ```bash
   ./gradlew deploy -Ddeploy.docker.container.id=$(docker ps -lq)
   ```

   The JAR is generated in the `build/libs` folder (i.e., `b4k8-impl/build/libs/com.acme.b4k8.impl-1.0.0.jar`).

1. Confirm the module was successfully deployed and started via the container console.

   ```log
   Processing com.acme.b4k8.impl-1.0.0.jar
   STARTED com.acme.b4k8.impl_1.0.0 [1656]
   ```

1. Verify the portlet filter is working by adding the Blogs widget to a Site Page.

   Whenever a render request is made to the Blogs portlet, the container console should display a warning message with an audit of its render time, average render time, and total number of renders.

   ```log
   WARN [http-nio-8080-exec-2][B4K8PortletFilter:54] Blogs portlet rendered in 3 ms with an average of 3 ms out of 1 renders.
   WARN [http-nio-8080-exec-10][B4K8PortletFilter:54] Blogs portlet rendered in 0 ms with an average of 1 ms out of 2 renders.
   ```

## Sample Render Filter Code

The provided sample filter targets the Blogs portlet and audits its render phase using the `RenderFilter` interface.

```java
@Component(
   property = {
      "javax.portlet.name=com_liferay_blogs_web_portlet_BlogsPortlet",
      "service.ranking:Integer=100"
   },
   service = PortletFilter.class
)
public class B4K8PortletFilter implements RenderFilter {

   @Override
   public void destroy() {
   }

   @Override
   public void doFilter(
         RenderRequest renderRequest, RenderResponse renderResponse,
         FilterChain filterChain)
      throws IOException, PortletException {

      long startTime = System.currentTimeMillis();

      filterChain.doFilter(renderRequest, renderResponse);

      long renderTime = (System.currentTimeMillis() - startTime) / 1000;

      _totalTime.add(renderTime);

      _count.increment();

      if (_log.isWarnEnabled()) {
         long count = _count.longValue();

         long averageRenderTime = _totalTime.longValue() / count;

         _log.warn(
            "Blogs portlet rendered in " + renderTime +
               " ms with an average of " + averageRenderTime +
                  " ms out of " + count + " renders.");
      }
   }

   @Override
   public void init(FilterConfig filterConfig) throws PortletException {
   }

   private static final Log _log = LogFactoryUtil.getLog(
      B4K8PortletFilter.class);

   private final LongAdder _count = new LongAdder();
   private final LongAdder _totalTime = new LongAdder();

}
```

In this code, the filter is first declared an OSGi DS Component and identified as a `PortletFilter.class` service. As part of this declaration, it also sets two properties: the first property targets the `BlogsPortlet`, and the second property sets its priority to `100`.

The portlet filter proceeds to implement the [`RenderFilter`](http://docs.liferay.com/portlet-api/3.0/javadocs/javax/portlet/filter/RenderFilter.html) interface, which extends the [`PortletFilter`](http://docs.liferay.com/portlet-api/3.0/javadocs/javax/portlet/filter/PortletFilter.html) interface. This interface includes three methods (i.e., `init`, `destroy`, `doFilter`) and performs its filtering tasks on both the render request to the Blogs portlet and its response.

* `init`: This method is only called when the portlet filter is first deployed to Liferay and initialized within the portlet container.

* `destroy`: This method can be called to remove the portlet filter from service.

* `doFilter`: This method is called by the portlet container each time a render request/response pair is passed through the chain due to a client request.

   In this example, `doFilter` audits the Blogs portlet in the following ways:

   1. Notes the render phase start time.

      ```java
      long startTime = System.currentTimeMillis();
      ```

   1. Executes the `doFilter` method for the `FilterChain` to invoke every `RenderFilter` in the chain.

      ```java
      filterChain.doFilter(renderRequest, renderResponse);
      ```

   1. Calculates the time it takes for the Blogs portlet to complete the render phase.

      ```java
      long renderTime = (System.currentTimeMillis() - startTime) / 1000;
      ```

   1. Adds the current render time to the total time of all renders.

      ```java
      _totalTime.add(renderTime);
      ```

   1. Increments the total number of portlet renders.

      ```java
      _count.increment();
      ```

   1. Uses the LongAdder utility to store the portlet's average render time and total number of renders, and then uses the Log utility to display these values along with the portlet's current render time.

      ```java
      if (_log.isWarnEnabled()) {
         long count = _count.longValue();

         long averageRenderTime = _totalTime.longValue() / count;

         _log.warn(
            "Blogs portlet rendered in " + renderTime +
               " ms with an average of " + averageRenderTime +
                  " ms out of " + count + " renders.");
      }
      ```

   Whenever a render request is made, this `doFilter` is called.

## Additional Information

* [Portlets](../../../developing-applications/developing-a-java-web-application/portlets.md)
<!--TASK: Add link to Using Portlet Filters article when finished -->
