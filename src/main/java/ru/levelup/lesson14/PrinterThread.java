package ru.levelup.lesson14;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

public class PrinterThread extends Thread {

    private final String word;

    public PrinterThread(String word) {
        this.word = word;
        setName(PrinterThread.class.getName());
    }

    @Override
    @SneakyThrows
    public void run() {
        while(!Thread.currentThread().isInterrupted()) {
            TimeUnit.MILLISECONDS.sleep(2L);
            System.out.println(String.format("%s %s: %s", Thread.currentThread().getId(),
                    Thread.currentThread().getName(), word));
        }
    }
}
