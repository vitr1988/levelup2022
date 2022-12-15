package ru.levelup.lesson7.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Employee {

    private Integer id;
    private String empName;
    private BigDecimal salary;
    private Department department;
}