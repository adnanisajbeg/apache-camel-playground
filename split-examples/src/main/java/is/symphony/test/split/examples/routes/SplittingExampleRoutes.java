package is.symphony.test.split.examples.routes;

import is.symphony.test.split.examples.model.Person;
import is.symphony.test.split.examples.routes.strategy.ListPersonAggregationStrategy;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;
import org.springframework.stereotype.Component;

@Component
public class SplittingExampleRoutes extends RouteBuilder {
    DataFormat personBinding = new BindyCsvDataFormat(Person.class);

    @Override
    public void configure() throws Exception {
        from("file://data?fileName=splittingdata.csv&noop=true")
                .id("splitting-simple-example")
                .log("splitting input... ${body}")
                .split(body().tokenize("\\n"), new ListPersonAggregationStrategy())
                    .log("Row: ${body}")
                    .unmarshal(personBinding)
                    .log("POJO: ${body}")
                .end()
                .log("list: ${body}")

        ;
    }
}
