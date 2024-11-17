package md5.exercise.ss2.bt4.service;
import md5.exercise.ss2.bt4.entity.Projects;

import java.util.List;
import java.util.Optional;

public interface ProjectsService {
    List<Projects> findAll();
    Optional<Projects> findById(Integer id);
    Projects save(Projects projects);
    void delete(Integer id);
    void update(Projects projects);
}
