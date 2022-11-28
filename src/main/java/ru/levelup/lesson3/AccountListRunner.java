package ru.levelup.lesson3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import static ru.levelup.lesson3.util.AccountNumberGenerator.generateAccountNumber;

public class AccountListRunner {

    private static final int THRESHOLD = 12;

    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account("12345", "Ivanov Vitalii"));
        accounts.add(0, new Account("54321", "Petrov Vladimir"));
        accounts.addAll(List.of(new Account("52442542", "Sidorov Egor"),
                new Account("56363424", "Efremova Alina")));

        for (int i = 0; i < 1000; i++) {
            accounts.add(new Account(generateAccountNumber(THRESHOLD), String.format("Client%d", i)));
        }

        System.out.println("Зарегистрированные счета: " + accounts);
//        for (Account account : accounts) {
//            int index = accounts.indexOf(account);
//            if (index % 2 == 0) {
//                accounts.remove(index);
////                accounts.remove(account);
//            }
//        }
//        for (int i = 0; i < accounts.size() - 1; i++) {
//            Account account = accounts.get(i);
//            if (i % 2 == 0) {
//                accounts.remove(i);
//            }
//        }
        int counter = 0;
        for (Iterator<Account> iter = accounts.iterator(); iter.hasNext(); ){
            iter.next();
            if (counter % 2 == 0) {
                iter.remove();
            }
            counter++;
        }
        System.out.println("Список счетов после удаления элементов на четных позициях: " + accounts);
        System.out.println("Количество элементов коллекции после удаления: " + accounts.size());

        List<Integer> digits = new LinkedList<>();
        digits.add(1);
        digits.add(125);
        digits.add(1024);
        digits.add(-25);
        digits.add(100);
        for (ListIterator<Integer> iterator = digits.listIterator(digits.size() - 1); iterator.hasPrevious();) {
            Integer previous = iterator.previous();
            if (previous <= 10) {
                iterator.remove();
            }
        }
        System.out.println("Коллекция после модификации: " + digits);
    }


}
