package md5.exercise.ss2.bt3.serviceimpl;

import md5.exercise.ss2.bt3.entity.Blog;
import md5.exercise.ss2.bt3.repository.BlogRepository;
import md5.exercise.ss2.bt3.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepository;
    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Optional<Blog> findById(Integer id) {
        return blogRepository.findById(id);
    }

    @Override
    public Blog save(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public void delete(Integer id) {
        blogRepository.deleteById(id);
    }

    @Override
    public void update(Blog blog) {
        blogRepository.save(blog);
    }

    public Page<Blog> findAllBlogs(int page, int size) {
        return blogRepository.findAll(PageRequest.of(page, size));
    }
}
