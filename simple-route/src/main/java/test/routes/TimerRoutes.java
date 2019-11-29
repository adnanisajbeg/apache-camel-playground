package test.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class TimerRoutes extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("timer://mytimer?period=1s&repeatCount=10")
                .log("Starting timer...")
                .to("direct:myFirstRoute");
    }
}
