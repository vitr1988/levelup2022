package ru.levelup.lesson4;

public class FigureRunner {

    public static void main(String[] args) {
        Rectangle square = new Square(2);
        System.out.println(square.square());
        System.out.println(square.perimeter());
    }
}
