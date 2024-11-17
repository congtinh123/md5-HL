package md5.exercise.ss2.bt4.serviceimpl;

import md5.exercise.ss2.bt4.entity.Customers;
import md5.exercise.ss2.bt4.repository.CustomersRepository;
import md5.exercise.ss2.bt4.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CustomersServiceImpl implements CustomersService {
    @Autowired
    private CustomersRepository customersRepository;
    @Override
    public List<Customers> findAll() {
        return customersRepository.findAll();
    }

    @Override
    public Optional<Customers> findById(Integer id) {
        return customersRepository.findById(id);
    }

    @Override
    public Customers save(Customers customers) {
        return customersRepository.save(customers);
    }

    @Override
    public void delete(Integer id) {
        customersRepository.deleteById(id);
    }

    @Override
    public void update(Customers customers) {
        customersRepository.save(customers);
    }
}
