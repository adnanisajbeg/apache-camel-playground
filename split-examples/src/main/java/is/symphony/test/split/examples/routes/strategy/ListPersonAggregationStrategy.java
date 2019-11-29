package is.symphony.test.split.examples.routes.strategy;

import is.symphony.test.split.examples.model.Person;
import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

import java.util.ArrayList;
import java.util.List;

public class ListPersonAggregationStrategy implements AggregationStrategy {

    @Override
    @SuppressWarnings("unchecked")
    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
        Person body = newExchange.getIn().getBody(Person.class);
        if (oldExchange == null) {
            List<Person> list = new ArrayList<>();
            if (body != null) {
                list.add(body);
            }
            newExchange.getIn().setBody(list);
            return newExchange;
        } else {
            List<Person> list = oldExchange.getIn().getBody(List.class);
            if (body != null) {
                list.add(body);
            }
            return oldExchange;
        }
    }
}
