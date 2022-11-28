package ru.levelup.lesson3;

import ru.levelup.lesson3.util.AccountNumberGenerator;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class AccountSetRunner {

    public static void main(String[] args) {
        Set<Account> accounts = Set.of(new Account("42542524", "Ivannikov Ivan"));
        Set<Account> hashAccounts = new LinkedHashSet<>();
        hashAccounts.add(new Account("132432", "Ivanov Vitalii"));
        hashAccounts.addAll(accounts);
        for (int i = 0; i < 100; i++) {
            hashAccounts.add(new Account(AccountNumberGenerator.generateAccountNumber(12), "Client" + i));
        }

        System.out.println("Все значения множества: " + hashAccounts);
        System.out.println("------------");
        for(Account account : hashAccounts) {
            if (account.getAccountNumber().length() < 12) {
                System.out.println(account);
            }
        }
        System.out.println("------------");
        Set<Account> treeAccounts = new TreeSet<>(new Comparator<Account>() {
            @Override
            public int compare(Account o1, Account o2) {
                return - o1.getValue().compareTo(o2.getValue());
            }
        });
        treeAccounts.add(new Account("345435425", "Petrov Peter").setValue(BigDecimal.valueOf(1_000_000)));
        treeAccounts.add(new Account("5454524", "Egorov Egor").setValue(BigDecimal.valueOf(10_000)));
        treeAccounts.add(new Account("542542542", "Ohlobystina Alena").setValue(BigDecimal.valueOf(50_000)));
        System.out.println(treeAccounts);

        Collections.addAll(treeAccounts, new Account("", ""), new Account("", ""));
    }
}
