package md5.exercise.ss4.bt1.controller;

import md5.exercise.ss4.bt1.entity.Category;
import md5.exercise.ss4.bt1.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getAll(){
        List<Category> categories = categoryService.findAll();
        return ResponseEntity.ok(categories);
    }

    @PostMapping
    public ResponseEntity<Category> addCategory(@RequestBody Category category){
        Category addCategory = categoryService.save(category);
        return ResponseEntity.ok(addCategory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Integer id, @RequestBody Category category){
        category.setCategoryId(id);
        Category updateCategory = categoryService.save(category);
        return ResponseEntity.ok(updateCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable Integer id){
        categoryService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findByIdCategory(@PathVariable Integer id){
        Category category = categoryService.findById(id);
        return ResponseEntity.ok(category);
    }
}
