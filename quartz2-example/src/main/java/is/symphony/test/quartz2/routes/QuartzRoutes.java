package is.symphony.test.quartz2.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class QuartzRoutes extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("quartz2://updateSongData?cron=0/0+*/5+*+*+*+?")
                .log("starting something with quartz...")
        ;

    }
}
