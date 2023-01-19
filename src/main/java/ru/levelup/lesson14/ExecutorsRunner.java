package ru.levelup.lesson14;

import ru.levelup.lesson14.service.Calculator;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorsRunner {

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        Future<Integer> submit = executorService.submit(() -> new Calculator(1, 2).summa());
//        System.out.println(submit.get());
        CompletableFuture.supplyAsync(() -> new Calculator(1, 2).summa(), executorService)
                .thenAccept(System.out::println)
                .join();
    }
}
