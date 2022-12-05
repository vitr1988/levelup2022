package ru.levelup.lesson4;

import lombok.Data;

@Data
public class Rectangle {

    final int a;
    final int b;

    public int perimeter() {
        return 2 * (a + b);
    }

    public int square() {
        return a * b;
    }
}
