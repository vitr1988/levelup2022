package ru.levelup.lesson3.util;

import java.util.Random;

public class AccountNumberGenerator {

    public static String generateAccountNumber(int size) {
//        String result = "";
        StringBuilder result = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
//            result += random.nextInt(10);
            result.append(random.nextInt(10));
        }
        return result.toString();
    }
}
