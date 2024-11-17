package md5.exercise.ss2.bt4.repository;

import md5.exercise.ss2.bt4.entity.Projects;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectsRepository extends JpaRepository<Projects, Integer> {
}
