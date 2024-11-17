package md5.exercise.ss1.bt2.service;

import md5.exercise.ss1.bt2.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> findByFullNameContainingOrDepartmentNameContaining(String fullName, String departmentName);
    List<Employee> findAll();
    Optional<Employee> findById(Integer id);
    Employee save(Employee employee);
    void delete(Integer id);
    void update(Employee employee);
}
