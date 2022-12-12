package ru.levelup.lesson5.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import ru.levelup.lesson5.dto.Movie;
import ru.levelup.lesson5.dto.MovieMaker;

@Configuration
@ComponentScan("ru.levelup.lesson5")
public class AppConfig {

    @Bean("mov")
    public Movie movie() {
        return new Movie("TestMovie", 2021, "TestAuthor");
    }

    @Bean(value = "movie")
    @Scope(value = "prototype", proxyMode = ScopedProxyMode.INTERFACES)
    public Movie movie2() {
        return new Movie("TestMovie2", 2022, "TestAuthor2");
    }

    @Bean
    public MovieMaker movieMaker(@Qualifier("mov") Movie movie) {
        return new MovieMaker(movie);
    }
}
