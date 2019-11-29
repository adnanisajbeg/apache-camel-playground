package test.web;

import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("app")
public class SimpleController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleController.class);

    @Produce(uri = "direct:myFirstRoute")
    private ProducerTemplate producerTemplate;

    @PostMapping("/simplePost")
    public String startingSimpleRoute(@RequestBody String input) {
        LOGGER.info("Incoming request with body: {}", input);
        producerTemplate.sendBody(input);

        return "ok";
    }
}
