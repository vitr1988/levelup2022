package ru.levelup.lesson8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.levelup.lesson8.entity.Employee;

import java.math.BigDecimal;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("select employee from Employee employee " +
//            "left join fetch employee.department " +
            "where employee.salary >= :sal")
    List<Employee> findBySalary(@Param("sal") BigDecimal salary);

    List<Employee> findByNameAndSalary(String name, BigDecimal salary);
}
