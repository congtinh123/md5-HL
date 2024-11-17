package md5.exercise.ss4.bt4.repository;

import md5.exercise.ss4.bt4.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
