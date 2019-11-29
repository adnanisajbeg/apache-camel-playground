package is.symphony.test.processor.examples.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class ReplaceProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        String inputData = (String) exchange.getIn().getBody();
        String fixed = inputData.replace(",", "-");
        exchange.getIn().setBody(fixed);
    }
}
