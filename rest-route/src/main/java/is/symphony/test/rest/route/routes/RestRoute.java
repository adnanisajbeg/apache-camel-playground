package is.symphony.test.rest.route.routes;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class RestRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        restConfiguration()
                .port(8080)
                .component("servlet");

        rest("/app/camel/restRoute")
                .id("rest-route-example")
                .post()
                    .to("direct:justLogIt")
                .get()
                    .to("direct:justLogIt")
                .get("/anotherGet")
                    .to("direct:justLogIt")
                .delete()
                    .to("direct:justLogIt");


        from("direct:justLogIt")
                .log(LoggingLevel.WARN, "Received with header: ${header.Content-Type}");


    }
}
