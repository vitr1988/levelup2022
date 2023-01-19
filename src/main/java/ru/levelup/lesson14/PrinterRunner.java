package ru.levelup.lesson14;

public class PrinterRunner {

    public static void main(String[] args) throws Exception {
        String word = "Hello";
        PrinterThread printerThread = new PrinterThread(word);
//        printerThread.setPriority(Thread.MAX_PRIORITY);
        printerThread.setDaemon(false);
        printerThread.start();
//        printerThread.interrupt();
        printerThread.join();

        Thread thread = new Thread(() -> System.out.println(String.format("%s %s: %s", Thread.currentThread().getId(),
                Thread.currentThread().getName(), word)));
        thread.start();
    }
}
