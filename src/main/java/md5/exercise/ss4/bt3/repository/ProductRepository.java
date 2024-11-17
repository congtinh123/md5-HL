package md5.exercise.ss4.bt3.repository;

import md5.exercise.ss4.bt3.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
