package md5.exercise.ss2.bt4.repository;

import md5.exercise.ss2.bt4.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomersRepository extends JpaRepository<Customers, Integer> {
}
