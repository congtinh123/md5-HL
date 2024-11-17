package md5.exercise.ss2.bt2.repository;

import md5.exercise.ss2.bt2.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
