package ru.levelup.lesson14.service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Calculator {

    private final int a;
    private final int b;

    public int summa() {
        return a + b;
    }

}
