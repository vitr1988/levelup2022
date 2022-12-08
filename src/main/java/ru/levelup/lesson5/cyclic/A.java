package ru.levelup.lesson5.cyclic;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class A implements DisposableBean {

    private final B b;

    public A(@Lazy B b) {
        this.b = b;
    }

    @PostConstruct
    public void init() {
        System.out.println("Перед началом работы бина вызывется метод init");
    }

    @PreDestroy
    public void remove() {
        System.out.println("Перед удалением контекста будет вызван метод remove");
    }

    public void a() {
        System.out.println("Print A");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Перед удалением контекста будет вызван метод destroy");
    }
}
