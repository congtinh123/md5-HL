package md5.exercise.ss2.bt2.controller;

import md5.exercise.ss2.bt2.entity.Department;
import md5.exercise.ss2.bt2.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @RequestMapping
    public String department(Model model) {
        List<Department> departments = departmentService.findAll();
        model.addAttribute("departments", departments);
        return "ss2/bt2/department/list";
    }
    // Hiển thị form thêm mới phòng ban
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        Department department = new Department();
        model.addAttribute("department", department);
        return "ss2/bt2/department/add";
    }

    // Xử lý thêm mới phòng ban
    @PostMapping("/save")
    public String saveDepartment(@ModelAttribute("department") Department department) {
        departmentService.save(department);
        return "redirect:/";
    }

    // Hiển thị form sửa phòng ban
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        Optional<Department> department = departmentService.findById(id);
        if (department.isPresent()) {
            model.addAttribute("department", department.get());
            return "ss2/bt2/department/edit"; // Trang form sửa phòng ban
        }
        return "redirect:/"; // Nếu không tìm thấy, quay lại danh sách
    }

    // Xử lý cập nhật thông tin phòng ban
    @PostMapping("/update/{id}")
    public String updateDepartment(@PathVariable("id") Integer id, @ModelAttribute("department") Department department) {
        departmentService.save(department);
        return "redirect:/"; // Sau khi cập nhật, quay lại danh sách
    }

    // Thay đổi trạng thái phòng ban
    @GetMapping("/status/{id}")
    public String changeStatus(@PathVariable("id") Integer id) {
        Optional<Department> department = departmentService.findById(id);
        if (department.isPresent()) {
            Department dep = department.get();
            dep.setStatus(!dep.isStatus()); // Thay đổi trạng thái
            departmentService.save(dep);
        }
        return "redirect:/"; // Sau khi thay đổi, quay lại danh sách
    }

    // Xóa phòng ban
    @GetMapping("/delete/{id}")
    public String deleteDepartment(@PathVariable("id") Integer id) {
        departmentService.delete(id);
        return "redirect:/"; // Sau khi xóa, quay lại danh sách
    }
}
