package md5.exercise.ss2.bt2.repository;

import md5.exercise.ss2.bt2.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
