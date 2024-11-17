package md5.exercise.ss4.bt4.controller;

import md5.exercise.ss4.bt4.entity.Employee;
import md5.exercise.ss4.bt4.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping
    public ResponseEntity<List<Employee>> findAll(){
        List<Employee> employees = employeeService.findAll();
        return ResponseEntity.ok(employees);
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee3){
        Employee addEmployee = employeeService.save(employee3);
        return ResponseEntity.ok(addEmployee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id, @RequestBody Employee employee3){
        employee3.setEmployeeId(id);
        Employee updateEmployee = employeeService.save(employee3);
        return ResponseEntity.ok(updateEmployee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Integer id){
        employeeService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable Integer id){
        return employeeService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
