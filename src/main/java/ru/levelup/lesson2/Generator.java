package ru.levelup.lesson2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generator {
    public static void main(String[] args) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        result.add(new Random(100).nextInt());
        result.add(123);
//        result.add("String");
        System.out.println(result);
        int summa = 0;
        for (Integer arg: result) {
//            summa = summa + (int) arg;
            summa += arg;
        }
        System.out.println(summa);
    }
}
