package ru.levelup.lesson5.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.levelup.lesson5.dto.Movie;

@Configuration
@ComponentScan("ru.levelup.lesson5")
public class AppConfig {

    @Bean
    public Movie movie() {
        return new Movie("TestMovie", 2021, "TestAuthor");
    }
}
