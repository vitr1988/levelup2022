package ru.levelup.lesson8.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.levelup.lesson8.entity.Department;
import ru.levelup.lesson8.repository.DepartmentRepository;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl {

    private final DepartmentRepository departmentRepository;

    public Department save(Department department) {
        return departmentRepository.save(department);
    }

}
