package ru.levelup.lesson8.service;

import ru.levelup.lesson8.entity.Employee;

import java.math.BigDecimal;
import java.util.List;

public interface EmployeeService {

    List<Employee> findBySalary(BigDecimal salary);

    List<Employee> findBySalaryAndName(String name, BigDecimal salary);

    void create(Employee employee);

    void update(Employee employee);

    void deleteById(Integer id);
}
