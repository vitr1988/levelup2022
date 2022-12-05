package ru.levelup.lesson4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamRunner {

    public static void main(String[] args) {
//        Stream<Long> longStream = List.of(1L, 54L, 434L, -1L, 0L, 121L).stream();
        Stream<Long> longStream = Stream.of(1L, 54L, 1L, 434L, -1L, 0L, 121L);
        longStream = longStream.filter(i -> i >= 0)
                .map(i -> 10 * i)
                .distinct()
                .limit(3)
                .peek(System.out::println)
                .sorted();
        System.out.println(longStream.collect(Collectors.toList()));
        System.out.println("----");
        DoubleStream doubleStream = Arrays.stream(new double[]{1.0, 2.0, -3.1});
        System.out.printf("Количество значений в стриме %d\n", doubleStream.count());
        System.out.println("----");

        Stream<Integer> integerStream = Stream.of(1, 2, 10);
//        Stream<Integer> integerStream = Stream.empty();
        System.out.println("Минимальное значение среди 1, 2, 10 = " + integerStream
                .min(Comparator.comparingInt(Integer::intValue))
                .or(() -> Optional.of(-1))
                .get());
        System.out.println("----");

//        Stream<Long> anotherStream = Stream.concat(longStream, LongStream.of(1L, 2L).boxed());

        List<String> words = new ArrayList<>();
        words.add("Vitalii");
        words.add("Semen");
        words.add("Ann");
        words.add("Peter");
        words.add("Vasya");
        words.add("Vasya");

        printWordsAndTheirLength(words);
        System.out.println("----");
        printWordsAndTheirLengthInFunctionStyle(words);
        System.out.println("----");
        System.out.println(convertToList(List.of(List.of("Maria", "Andrey", "Sergey"), List.of("Alex", "Victoria"))));
        System.out.println("----");
        System.out.println(reversed(List.of("Первый", "Второй", "Третий", "Четвертый", "Пятый")));
    }

    private static void printWordsAndTheirLengthInFunctionStyle(List<String> words) {
//        System.out.println(words.stream().collect(Collectors.toMap(word -> word, word -> word.length())));
        System.out.println(words.stream().collect(Collectors.toMap(Function.identity(), String::length, (a, b) -> a)));
    }

    private static void printWordsAndTheirLength(List<String> words) {
        Map<String, Integer> result = new HashMap<>(words.size());
        for (String word: words) {
            result.put(word, word.length());
        }
        System.out.println(result);
    }

    private static List<String> convertToList(List<List<String>> wordList) {
        return wordList.stream()//.flatMap(list -> list.stream())
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    private static List<String> reversed(List<String> input) {
        return input.stream()
                .sorted(Comparator.comparingInt(input::indexOf).reversed())
                .collect(Collectors.toList());
    }
}
