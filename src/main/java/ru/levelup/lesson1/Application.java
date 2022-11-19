package ru.levelup.lesson1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RestController
    public class HelloWorldController {

        @GetMapping({"/hello","/hello/{name}"})
        public String hello(@PathVariable Optional<String> name) {
            return String.format("Hello, %s", name.orElse("World"));
        }
    }

}
