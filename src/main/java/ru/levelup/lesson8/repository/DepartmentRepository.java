package ru.levelup.lesson8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.levelup.lesson8.entity.Department;

//@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
