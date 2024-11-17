package md5.exercise.ss4.bt4.controller;

import md5.exercise.ss4.bt4.entity.Department;
import md5.exercise.ss4.bt4.entity.Employee;
import md5.exercise.ss4.bt4.service.DepartmentService;
import md5.exercise.ss4.bt4.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private EmployeeService employeeService;
    @GetMapping
    public ResponseEntity<List<Department>> findAll(){
        List<Department> department1s = departmentService.findAll();
        return ResponseEntity.ok(department1s);
    }

    @PostMapping
    public ResponseEntity<Department> addDepartment(@RequestBody Department department1){
        Department addDepartment = departmentService.save(department1);
        return ResponseEntity.ok(addDepartment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable Integer id, @RequestBody Department department1){
        department1.setDepartmentId(id);
        Department updateDepartment = departmentService.save(department1);
        return ResponseEntity.ok(updateDepartment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable Integer id){
        departmentService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> findDepartmentById(@PathVariable Integer id){
        return departmentService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/departments/{id}/status")
    public ResponseEntity<Department> changeDepartmentStatus(@PathVariable int id, @RequestParam boolean status) {
        Optional<Department> department = departmentService.findById(id);
        if (department.isPresent()) {
            Department existingDepartment = department.get();
            existingDepartment.setStatus(status);
            Department updatedDepartment = departmentService.save(existingDepartment);
            return ResponseEntity.ok(updatedDepartment);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping("/employees/add")
    public ResponseEntity<Employee> addEmployeeToDepartment(@RequestBody Employee employee, @RequestParam int departmentId) {
        Optional<Department> department = departmentService.findById(departmentId);
        if (department.isPresent()) {
            employee.setDepartment(department.get());
            Employee newEmployee = employeeService.save(employee);
            return ResponseEntity.status(HttpStatus.CREATED).body(newEmployee);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/employees/{id}/remove-from-department")
    public ResponseEntity<Employee> removeEmployeeFromDepartment(@PathVariable int id) {
        Optional<Employee> employee = employeeService.findById(id);
        if (employee.isPresent()) {
            Employee existingEmployee = employee.get();
            existingEmployee.setDepartment(null); // Xóa liên kết phòng ban
            Employee updatedEmployee = employeeService.save(existingEmployee);
            return ResponseEntity.ok(updatedEmployee);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
