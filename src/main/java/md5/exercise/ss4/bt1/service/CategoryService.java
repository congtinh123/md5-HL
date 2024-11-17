package md5.exercise.ss4.bt1.service;

import md5.exercise.ss4.bt1.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category findById(Integer id);
    Category save(Category category);
    void delete(Integer id);
    void update(Category category);
}
