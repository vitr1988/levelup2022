package ru.levelup.lesson8;

import liquibase.pro.packaged.D;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.levelup.lesson8.entity.Department;
import ru.levelup.lesson8.entity.Employee;
import ru.levelup.lesson8.service.EmployeeService;
import ru.levelup.lesson8.service.impl.DepartmentServiceImpl;

import java.math.BigDecimal;

@SpringBootApplication
public class EmployeeJpaRunner {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(EmployeeJpaRunner.class, args);
        EmployeeService employeeService = context.getBean(EmployeeService.class);
        System.out.println(employeeService.findBySalary(BigDecimal.valueOf(1500)));

        Department department = new Department(12, "Test department");
        DepartmentServiceImpl departmentService = context.getBean(DepartmentServiceImpl.class);
        department = departmentService.save(department);
        employeeService.create(new Employee(26, "Petrov Gennady", BigDecimal.ONE, department));

        employeeService.deleteById(26);
    }
}
