package ru.levelup.lesson3.function;

import ru.levelup.lesson3.Account;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalRunner {

    public static void main(String[] args) {
        PrintableFunctionalInterface printer = word -> System.out.println(word);
        Function<String, String> suffix = word -> "Hello, " + word;
        Supplier<Integer> intGenerator = () -> new Random().nextInt();
        Consumer<Account> printerAccount = account -> printer.print(account.toString());
        Predicate<Long> longChecker = value -> value != 0;
    }
}
