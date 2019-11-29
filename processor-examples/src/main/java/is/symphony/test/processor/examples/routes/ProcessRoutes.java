package is.symphony.test.processor.examples.routes;

import is.symphony.test.processor.examples.processor.ReplaceProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessRoutes extends RouteBuilder {

    @Autowired
    ReplaceProcessor replaceProcessor;

    @Override
    public void configure() throws Exception {
        from("direct:processInputData")
                .id("process-input-data")
                .log("Received: ${body}")
                .process(e -> {
                    String inputData = (String) e.getIn().getBody();
                    String fixed = inputData.replace(",", ";");
                    e.getIn().setBody(fixed);
                })
                .log("New body: ${body}");

        from("direct:processAnotherInputData")
                .id("process-input-data-second")
                .log("Received: ${body}")
                .process(replaceProcessor)
                .log("New body: ${body}");
    }
}
