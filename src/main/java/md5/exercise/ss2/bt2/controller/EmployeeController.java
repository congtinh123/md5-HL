package md5.exercise.ss2.bt2.controller;

import md5.exercise.ss2.bt2.entity.Department;
import md5.exercise.ss2.bt2.entity.Employee;
import md5.exercise.ss2.bt2.service.DepartmentService;
import md5.exercise.ss2.bt2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;

    // Display list of employees
    @GetMapping("/")
    public String listEmployees(Model model) {
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);
        return "ss2/bt2/employee/list";
    }

    // Show form to add a new employee
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        Employee employee = new Employee();
        List<Department> departments = departmentService.findAll();
        model.addAttribute("employee", employee);
        model.addAttribute("departments", departments);
        return "ss2/bt2/employee/add";
    }

    // Save new employee
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);
        return "redirect:/";
    }

    // Show form to edit an employee
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        Optional<Employee> employee = employeeService.findById(id);
        if (employee.isPresent()) {
            List<Department> departments = departmentService.findAll();
            model.addAttribute("employee", employee.get());
            model.addAttribute("departments", departments);
            return "ss2/bt2/employee/edit";
        }
        return "redirect:/";
    }

    // Update employee details
    @PostMapping("/edit")
    public String updateEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);
        return "redirect:/";
    }

    // Change employee status
    @GetMapping("/status/{id}")
    public String changeStatus(@PathVariable("id") Integer id) {
        Optional<Employee> employee = employeeService.findById(id);
        if (employee.isPresent()) {
            Employee emp = employee.get();
            emp.setStatus(!emp.isStatus());
            employeeService.save(emp);
        }
        return "redirect:/";
    }

    // Delete employee
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id) {
        employeeService.delete(id);
        return "redirect:/";
    }
}
