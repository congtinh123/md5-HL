package md5.exercise.ss4.bt3.controller;

import md5.exercise.ss4.bt3.entity.Category;
import md5.exercise.ss4.bt3.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        List<Category> category1s = categoryService.findAll();
        return ResponseEntity.ok(category1s);
    }

    @PostMapping
    public ResponseEntity<Category> addCategory(@RequestBody Category category1){
        Category newCategory = categoryService.save(category1);
        return ResponseEntity.ok(newCategory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Integer id, @RequestBody Category category1){
        category1.setCategoryId(id);
        Category updatedCategory = categoryService.save(category1);
        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Integer id){
        categoryService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public Category findByIdCategory(@PathVariable Integer id){
        return categoryService.findById(id);
    }
}
