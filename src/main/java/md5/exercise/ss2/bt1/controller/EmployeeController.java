package md5.exercise.ss2.bt1.controller;

import md5.exercise.ss2.bt1.entity.Employee;
import md5.exercise.ss2.bt1.service.EmployeeService;
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

    @GetMapping("/")
    public String listEmployees(Model model) {
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);
        return "ss2/bt1/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "ss2/bt1/add";
    }

    @PostMapping("/add")
    public String addEmployee(@ModelAttribute Employee employee) {
        employeeService.save(employee);
        return "redirect:/";
    }

    @GetMapping("/edit/{employeeId}")
    public String showEditForm(@PathVariable Integer employeeId, Model model) {
        Optional<Employee> optionalEmployee = employeeService.findById(employeeId);

        if (optionalEmployee.isPresent()) {
            model.addAttribute("employee", optionalEmployee.get());
        } else {
            return "redirect:/";
        }

        return "ss2/bt1/edit";
    }

    @PostMapping("/edit")
    public String editEmployee(@ModelAttribute Employee employee) {
        employeeService.update(employee);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Integer id) {
        employeeService.delete(id);
        return "redirect:/";
    }
}

