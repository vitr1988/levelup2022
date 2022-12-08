package ru.levelup.lesson5.bean;

import org.springframework.stereotype.Component;

@Component
public class TestBean {

    public void printPhrase(String phrase) {
        System.out.println(phrase);
    }
}
