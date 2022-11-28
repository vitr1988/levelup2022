package ru.levelup.lesson3.function;

@FunctionalInterface
public interface PrintableFunctionalInterface {
    void print(String word);

    default Class<?> getClazz() {
        return this.getClass();
    }

    default void printClass() {
        print(getClazz().getCanonicalName());
    }

    static void printHelloWorld() {
        System.out.println("Hello World");
    }
}
