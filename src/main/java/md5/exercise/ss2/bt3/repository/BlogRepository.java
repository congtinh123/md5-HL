package md5.exercise.ss2.bt3.repository;

import md5.exercise.ss2.bt3.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
}
