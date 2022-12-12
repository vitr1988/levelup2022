package ru.levelup.lesson6.bean.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import ru.levelup.lesson6.bean.Printer;

@Component
@Scope(value = "prototype", proxyMode = ScopedProxyMode.INTERFACES)
public class SoutPrinter implements Printer {

    private Integer counter = 0;

    @Override
    public void print(String arg) {
        System.out.println(String.format("%s,%d", arg, ++counter));
    }
}
