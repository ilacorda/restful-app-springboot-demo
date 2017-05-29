package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String contentTemplate = "Content, %s!";
    private static final String descriptionTemplate = "Description, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="defaultText") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(contentTemplate, name),
                            String.format(descriptionTemplate, name));
    }
}