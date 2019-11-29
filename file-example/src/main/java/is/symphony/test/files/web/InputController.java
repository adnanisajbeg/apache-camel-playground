package is.symphony.test.files.web;

import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InputController {
    private static final Logger LOGGER = LoggerFactory.getLogger(InputController.class);

    @Produce(uri = "direct:storeInFile")
    private ProducerTemplate producerTemplate;

    @PostMapping("/store")
    public String firstCase(@RequestBody String inputData) {
        LOGGER.info("Data received...");

        producerTemplate.sendBody(inputData);

        LOGGER.info("Data stored in file...");
        return "ok";
    }
}
