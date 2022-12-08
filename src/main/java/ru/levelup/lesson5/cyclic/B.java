package ru.levelup.lesson5.cyclic;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class B {

    private final A a;

    public B(@Lazy A a) {
        this.a = a;
    }


    public void print() {
        System.out.println("Print B");
    }
}
