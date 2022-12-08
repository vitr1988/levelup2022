package ru.levelup.lesson5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.levelup.lesson5.dto.Movie;

@SpringBootApplication
public class MovieBeanRunner {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MovieBeanRunner.class, args);
        Movie bean = context.getBean(Movie.class);
        System.out.println(bean);
    }
}
