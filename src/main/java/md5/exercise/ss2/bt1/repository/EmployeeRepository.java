package md5.exercise.ss2.bt1.repository;

import md5.exercise.ss2.bt1.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
