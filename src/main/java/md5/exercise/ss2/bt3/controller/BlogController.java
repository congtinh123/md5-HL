package md5.exercise.ss2.bt3.controller;

import md5.exercise.ss2.bt3.entity.Blog;
import md5.exercise.ss2.bt3.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;
    @GetMapping
    public String listBlogs(@RequestParam(defaultValue = "0") int page, Model model) {
        int pageSize = 3; // Số lượng blog trên mỗi trang
        Page<Blog> blogPage = blogService.findAllBlogs(page, pageSize);
        model.addAttribute("blogPage", blogPage);
        return "/ss2/bt3/list";
    }

    // Hiển thị form thêm mới blog
    @GetMapping("/add")
    public String showCreateForm(Model model) {
        Blog blog = new Blog(); // Tạo một đối tượng Blog mới
        model.addAttribute("blog", blog);
        return "/ss2/bt3/add"; // Đường dẫn tới template tạo mới blog
    }

    // Xử lý lưu blog mới
    @PostMapping("/add")
    public String saveBlog(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog); // Lưu blog vào cơ sở dữ liệu
        return "redirect:/"; // Chuyển hướng về danh sách blog
    }

    // Hiển thị form sửa blog
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        Optional<Blog> blog = blogService.findById(id);
        if (blog.isPresent()) {
            model.addAttribute("blog", blog.get());
            return "/ss2/bt3/edit"; // Đường dẫn tới template sửa blog
        }
        return "redirect:/"; // Nếu không tìm thấy, quay lại danh sách
    }

    // Xử lý cập nhật thông tin blog
    @PostMapping("/edit")
    public String updateBlog(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog); // Cập nhật blog trong cơ sở dữ liệu
        return "redirect:/"; // Chuyển hướng về danh sách blog
    }

    // Xóa blog
    @GetMapping("/delete/{id}")
    public String deleteBlog(@PathVariable("id") Integer id) {
        blogService.delete(id); // Xóa blog theo id
        return "redirect:/"; // Chuyển hướng về danh sách blog
    }
}
