package is.symphony.test.receivers.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MultipleReceiversRoutes extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("seda:multipleReceivers")
                .id("multiple-receivers")
                .to("direct:routeOne")
                .to("direct:routeTwo")
                .to("direct:routeThree");

        from("direct:routeOne")
                .id("route-one")
                .log("Route One activated!")
                .end();

        from("direct:routeTwo")
                .id("route-two")
                .log("Route Two activated!")
                .end();

        from("direct:routeThree")
                .id("route-three")
                .log("Route Three activated!")
                .end();
    }
}
