package ru.levelup.lesson3;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Accessors(chain = true)
@RequiredArgsConstructor
public class Account /*implements Comparable<Account>*/ {

    private final String accountNumber;
    private String bic;
    private BigDecimal value = BigDecimal.ZERO;
    private final String clientName;

    public void deposit(BigDecimal money) {
        this.value = this.value.add(money);
    }

    public void withdraw(BigDecimal money) {
        this.value = this.value.subtract(money);
//        this.deposit(BigDecimal.valueOf(-1).multiply(money));
    }

//    @Override
//    public int compareTo(Account o) {
//        return - value.compareTo(o. value);
//    }
}
