package md5.exercise.ss2.bt2.service;

import md5.exercise.ss2.bt2.entity.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    List<Department> findAll();
    Optional<Department> findById(Integer id);
    Department save(Department department);
    void delete(Integer id);
    void update(Department department);
}
