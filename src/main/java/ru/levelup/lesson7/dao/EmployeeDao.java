package ru.levelup.lesson7.dao;

import ru.levelup.lesson7.model.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> findAll();
}
