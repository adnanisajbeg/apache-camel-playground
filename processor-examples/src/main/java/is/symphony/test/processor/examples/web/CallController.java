package is.symphony.test.processor.examples.web;

import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CallController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CallController.class);

    @Produce(uri = "direct:processInputData")
    private ProducerTemplate producerTemplateFirst;

    @Produce(uri = "direct:processAnotherInputData")
    private ProducerTemplate producerTemplateSecond;

    @PostMapping("/processData")
    public String firstCase(@RequestBody String inputData) {
        LOGGER.info("Data received...");

        producerTemplateFirst.sendBody(inputData);

        LOGGER.info("Data processed...");
        return "ok";
    }

    @PostMapping("/processAnotherData")
    public String secondCase(@RequestBody String inputData) {
        LOGGER.info("Data received...");

        producerTemplateSecond.sendBody(inputData);

        LOGGER.info("Data processed...");
        return "ok";
    }

}
