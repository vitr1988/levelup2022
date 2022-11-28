package ru.levelup.lesson3;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class AccountMapRunner {

    public static void main(String[] args) {
        Map<Integer, String> regionMap = new LinkedHashMap<>();
        regionMap.put(77, "Moscow Region");
        regionMap.put(63, "Samara Region");
        regionMap.put(78, "Saint Petersburg");
        regionMap.put(55, "Orenburg");
        regionMap.put(13, null);
        regionMap.put(63, "Samara");

        System.out.println("Значение 77го региона: " + regionMap.get(77));
        System.out.println("Значение 01го региона: " + regionMap.get(1));
        System.out.println("Значение 13го региона: " + regionMap.get(13));

        System.out.println("Признак наличия 14го региона: " + regionMap.containsKey(14));
        System.out.println("Признак наличия 13го региона: " + regionMap.containsKey(13));

        System.out.println("Значение 63го региона: " + regionMap.get(63));

        System.out.println("-----");
        for (Map.Entry<Integer, String> entry: regionMap.entrySet()) {
            System.out.println(entry);
        }

    }
}
