package milesahead.micro.service2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class Service2Controller {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/service2")
    public Service2 service1(@RequestParam(value = "name", defaultValue = "Service2") String name) {
        return new Service2(counter.incrementAndGet(), String.format(template, name));
    }
}
