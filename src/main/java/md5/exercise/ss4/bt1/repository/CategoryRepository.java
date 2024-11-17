package md5.exercise.ss4.bt1.repository;

import md5.exercise.ss4.bt1.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
