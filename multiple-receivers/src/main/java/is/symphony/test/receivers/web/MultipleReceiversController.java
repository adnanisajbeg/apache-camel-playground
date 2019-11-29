package is.symphony.test.receivers.web;


import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MultipleReceiversController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MultipleReceiversController.class);

    @Produce(uri = "seda:multipleReceivers")
    private ProducerTemplate producerTemplate;

    @GetMapping("/multipleReceivers")
    public String firstCase() {
        LOGGER.info("Testing multiple receiver route...");

        producerTemplate.sendBody("test");

        LOGGER.info("Returning ok result...");
        return "ok";
    }
}
