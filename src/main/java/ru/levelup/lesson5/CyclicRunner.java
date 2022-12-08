package ru.levelup.lesson5;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.levelup.lesson5.config.AppConfig;
import ru.levelup.lesson5.cyclic.A;

public class CyclicRunner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        A bean = context.getBean(A.class);
        bean.a();
    }
}
