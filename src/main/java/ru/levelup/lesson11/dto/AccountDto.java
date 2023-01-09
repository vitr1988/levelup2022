package ru.levelup.lesson11.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountDto {

    private Long id;
    private String owner;
    private BigDecimal balance;
}
