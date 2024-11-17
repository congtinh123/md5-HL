package md5.exercise.ss1.bt2.controller;

import md5.exercise.ss1.bt2.entity.Employee;
import md5.exercise.ss1.bt2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/ss1/baitap2")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String listEmployees(Model model) {
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);
        return "ss1/bt2/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "ss1/bt2/add";
    }

    @PostMapping("/add")
    public String addEmployee(@ModelAttribute Employee employee) {
        employeeService.save(employee);
        return "redirect:/baitap2";
    }

    @GetMapping("/edit/{employeeId}")
    public String showEditForm(@PathVariable Integer employeeId, Model model) {
        Optional<Employee> optionalEmployee = employeeService.findById(employeeId);

        if (optionalEmployee.isPresent()) {
            model.addAttribute("employee", optionalEmployee.get());
        } else {
            return "redirect:/baitap2"; // chuyển hướng về danh sách nhân viên
        }

        return "ss1/bt2/edit";
    }

    @PostMapping("/edit")
    public String editEmployee(@ModelAttribute Employee employee) {
        employeeService.update(employee);
        return "redirect:/baitap2"; // chuyển hướng về danh sách nhân viên
    }


    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Integer id) {
        employeeService.delete(id);
        return "redirect:/baitap2"; // Chuyển hướng về danh sách nhân viên
    }
}
