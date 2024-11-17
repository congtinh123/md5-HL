package md5.exercise.ss2.bt1.service;

import md5.exercise.ss2.bt1.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> findAll();
    Optional<Employee> findById(Integer id);
    Employee save(Employee employee);
    void delete(Integer id);
    void update(Employee employee);
}
