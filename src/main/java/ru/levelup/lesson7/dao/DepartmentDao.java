package ru.levelup.lesson7.dao;

import ru.levelup.lesson7.model.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentDao {
    List<Department> findAll();
    Optional<Department> getById(int departmentId);
    int create(Department department);
    void update(Department department);
    void deleteById(int departmentId);
}
