package md5.exercise.ss1.bt3.service;

import md5.exercise.ss1.bt3.entity.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    List<Account> findAll();
    Optional<Account> findById(Integer id);
    Account save(Account account);
    void delete(Integer id);
    void update(Account account);
}
