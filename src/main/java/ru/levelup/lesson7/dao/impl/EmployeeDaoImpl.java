package ru.levelup.lesson7.dao.impl;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.levelup.lesson7.dao.DepartmentDao;
import ru.levelup.lesson7.dao.EmployeeDao;
import ru.levelup.lesson7.model.Department;
import ru.levelup.lesson7.model.Employee;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    private final NamedParameterJdbcOperations jdbcOperations;

    private final RowMapper<Employee> employeeRowMapper;

    public EmployeeDaoImpl(NamedParameterJdbcOperations jdbcOperations, DepartmentDao departmentDao) {
        this.jdbcOperations = jdbcOperations;
        this.employeeRowMapper = (rs, row) -> {
            final Employee employee = new Employee();
            employee.setId(rs.getInt("emp_id"));
            employee.setEmpName(rs.getString("emp_name"));
            Department department = departmentDao.getById(rs.getInt("department_id")).orElse(null);
            employee.setDepartment(department);
            employee.setSalary(rs.getBigDecimal("salary"));
            return employee;
        };
    }

    @Override
    public List<Employee> findAll() {
        //language=SQL
        final String sql = "SELECT * FROM employee e";
        return jdbcOperations.query(sql, employeeRowMapper);
    }
}
