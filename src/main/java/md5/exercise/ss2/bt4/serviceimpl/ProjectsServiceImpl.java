package md5.exercise.ss2.bt4.serviceimpl;


import md5.exercise.ss2.bt4.entity.Projects;
import md5.exercise.ss2.bt4.repository.ProjectsRepository;
import md5.exercise.ss2.bt4.service.ProjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectsServiceImpl implements ProjectsService {
    @Autowired
    private ProjectsRepository projectsRepository;
    @Override
    public List<Projects> findAll() {
        return projectsRepository.findAll();
    }

    @Override
    public Optional<Projects> findById(Integer id) {
        return projectsRepository.findById(id);
    }

    @Override
    public Projects save(Projects projects) {
        return projectsRepository.save(projects);
    }

    @Override
    public void delete(Integer id) {
        projectsRepository.deleteById(id);
    }

    @Override
    public void update(Projects projects) {
        projectsRepository.save(projects);
    }
}
