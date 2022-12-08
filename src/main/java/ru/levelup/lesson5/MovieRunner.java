package ru.levelup.lesson5;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.levelup.lesson5.config.AppConfig;

public class MovieRunner {

    public static void main(String[] args) {
//        MovieLister movieLister = new MovieLister(new DatabaseFinder());
//        MovieLister movieLister = new MovieLister(new ColonSeparatedMovieFinder());
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MovieLister movieLister = context.getBean(MovieLister.class);
        System.out.println(movieLister.getFilms());
    }
}
