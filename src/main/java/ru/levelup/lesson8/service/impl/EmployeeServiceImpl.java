package ru.levelup.lesson8.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.levelup.lesson8.entity.Employee;
import ru.levelup.lesson8.repository.EmployeeRepository;
import ru.levelup.lesson8.service.EmployeeService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Setter(onMethod_ = @Autowired)
    private EmployeeService self;

    @Override
    public List<Employee> findBySalary(BigDecimal salary) {
        return employeeRepository.findBySalary(salary);
    }

    @Override
    public List<Employee> findBySalaryAndName(String name, BigDecimal salary) {
        return employeeRepository.findByNameAndSalary(name, salary);
    }

    @Override
    @Transactional
    public void create(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    @Transactional(rollbackFor = {IOException.class, FileNotFoundException.class},
            noRollbackFor = {NullPointerException.class})
    public void update(Employee employee) {
        employeeRepository.save(employee);
        self.deleteById(employee.getEmpId());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void deleteById(Integer id) {
        employeeRepository.deleteById(id);
    }
}
