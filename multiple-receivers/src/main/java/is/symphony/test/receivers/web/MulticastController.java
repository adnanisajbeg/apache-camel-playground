package is.symphony.test.receivers.web;

import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MulticastController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MulticastController.class);

    @Produce(uri = "seda:multicastExample")
    private ProducerTemplate producerTemplate;

    @GetMapping("/multicastExample")
    public String firstCase() {
        LOGGER.info("Testing multicast route...");

        producerTemplate.sendBody("test");

        LOGGER.info("Returning ok result...");
        return "ok";
    }

}
