package md5.exercise.ss4.bt4.repository;

import md5.exercise.ss4.bt4.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
