package md5.exercise.ss4.bt3.service;

import md5.exercise.ss4.bt3.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(Integer id);
    Product save(Product product);
    void delete(Integer id);
    void update(Product product);
}
