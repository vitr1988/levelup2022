package ru.levelup.lesson8.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.levelup.lesson8.entity.Employee;
import ru.levelup.lesson8.repository.EmployeeRepository;
import ru.levelup.lesson8.service.EmployeeService;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findBySalary(BigDecimal salary) {
        return employeeRepository.findBySalary(salary);
    }

    @Override
    public List<Employee> findBySalaryAndName(String name, BigDecimal salary) {
        return employeeRepository.findByNameAndSalary(name, salary);
    }

    @Override
    public void create(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void update(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteById(Integer id) {
        employeeRepository.deleteById(id);
    }
}
