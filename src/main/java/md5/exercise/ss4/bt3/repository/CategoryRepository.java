package md5.exercise.ss4.bt3.repository;

import md5.exercise.ss4.bt3.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
