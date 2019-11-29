package is.symphony.test.receivers.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MulticastReceiversRoutes extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("seda:multicastExample")
                .id("multicast-example")
                .multicast().parallelProcessing()
                .to("direct:routeOne")
                .to("direct:routeTwo")
                .to("direct:routeThree")
                .to("log:is.symphony.test.endpoint?level=WARN&showBody=true");;
    }
}
