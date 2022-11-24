package ru.levelup.lesson2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class CollectionRunner {

    public static void main(String[] args) {
        List<String> strList = List.of("Peter", "Eve", "Maria", "Dorian", "Peter");
        System.out.println(strList);
//        Set<Integer> digits = Set.of(1, -100, 25, 15, 15);
        Set<Integer> anotherDigits = new HashSet<>(5);
        anotherDigits.add(1);
        anotherDigits.add(-100);
        anotherDigits.add(25);
        anotherDigits.add(15);
        anotherDigits.add(15);
        System.out.println(anotherDigits);
        Queue<Float> queue = new LinkedList<>();
        queue.add(1.2f);
        queue.add(0f);
        System.out.println(queue);
    }
}
