package md5.exercise.ss2.bt3.service;

import md5.exercise.ss2.bt2.entity.Employee;
import md5.exercise.ss2.bt3.entity.Blog;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface BlogService {
    List<Blog> findAll();
    Optional<Blog> findById(Integer id);
    Blog save(Blog blog);
    void delete(Integer id);
    void update(Blog blog);
    Page<Blog> findAllBlogs(int page, int size);

}
