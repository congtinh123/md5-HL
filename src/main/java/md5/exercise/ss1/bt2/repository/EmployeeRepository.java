package md5.exercise.ss1.bt2.repository;
import md5.exercise.ss1.bt2.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //tìm kiếm theo tên hoặc phòng ban
    List<Employee> findByFullNameContainingOrDepartmentNameContaining(String fullName, String departmentName);
}
