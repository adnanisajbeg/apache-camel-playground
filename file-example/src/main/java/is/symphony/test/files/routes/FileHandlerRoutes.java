package is.symphony.test.files.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class FileHandlerRoutes extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:storeInFile")
                .id("store-in-file")
                .to("file://data?fileName=input.csv");

        from("file://data?fileName=input.csv")
                .to("file://copy?fileName=copied.csv");
    }
}
