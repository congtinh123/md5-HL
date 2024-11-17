package md5.exercise.ss1.bt2.serviceimpl;

import md5.exercise.ss1.bt2.entity.Employee;
import md5.exercise.ss1.bt2.repository.EmployeeRepository;
import md5.exercise.ss1.bt2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(Integer id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void delete(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public void update(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findByFullNameContainingOrDepartmentNameContaining(String fullName, String departmentName) {
        return employeeRepository.findByFullNameContainingOrDepartmentNameContaining(fullName, departmentName);
    }
}
