package test.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class BasicRoutes extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:myFirstRoute")
                .id("First Route")
                .log("Starting route with body: ${body}");

    }
}
