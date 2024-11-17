package md5.exercise.ss1.bt1.service;
import md5.exercise.ss1.bt1.entity.Product;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();
    Optional<Product> findById(Integer id);
    Product save(Product product);
    void delete(Integer id);
    void update(Product product);
}
