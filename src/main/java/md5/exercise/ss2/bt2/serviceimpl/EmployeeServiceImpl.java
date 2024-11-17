package md5.exercise.ss2.bt2.serviceimpl;

import md5.exercise.ss2.bt2.entity.Employee;
import md5.exercise.ss2.bt2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeService employeeService;
    @Override
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @Override
    public Optional<Employee> findById(Integer id) {
        return employeeService.findById(id);
    }

    @Override
    public Employee save(Employee employee) {
        return employeeService.save(employee);
    }

    @Override
    public void delete(Integer id) {
        employeeService.delete(id);
    }

    @Override
    public void update(Employee employee) {
        employeeService.update(employee);
    }
}
