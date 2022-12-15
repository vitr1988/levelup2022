package ru.levelup.lesson7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.levelup.lesson7.dao.DepartmentDao;
import ru.levelup.lesson7.dao.EmployeeDao;
import ru.levelup.lesson7.model.Department;

@SpringBootApplication
public class DaoRunner {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DaoRunner.class, args);
        DepartmentDao departmentDao = context.getBean(DepartmentDao.class);
        departmentDao.create(new Department(1, "IT"));
        System.out.println("---");
        EmployeeDao employeeDao = context.getBean(EmployeeDao.class);
        System.out.println(employeeDao.findAll());
    }
}
