package ru.levelup.lesson6.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("ru.levelup.lesson6")
@PropertySource("classpath:report.properties")
public class ApplicationConfig {
}
