package md5.exercise.ss2.bt4.service;
import md5.exercise.ss2.bt4.entity.Customers;

import java.util.List;
import java.util.Optional;

public interface CustomersService {
    List<Customers> findAll();
    Optional<Customers> findById(Integer id);
    Customers save(Customers customers);
    void delete(Integer id);
    void update(Customers customers);
}
