package md5.exercise.ss2.bt2.serviceimpl;

import md5.exercise.ss2.bt2.entity.Department;
import md5.exercise.ss2.bt2.repository.DepartmentRepository;
import md5.exercise.ss2.bt2.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Optional<Department> findById(Integer id) {
        return departmentRepository.findById(id);
    }

    @Override
    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public void delete(Integer id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public void update(Department department) {
        departmentRepository.save(department);
    }
}
