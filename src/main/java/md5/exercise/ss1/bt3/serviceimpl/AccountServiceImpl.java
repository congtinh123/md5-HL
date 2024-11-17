package md5.exercise.ss1.bt3.serviceimpl;

import md5.exercise.ss1.bt3.entity.Account;
import md5.exercise.ss1.bt3.repository.AccountRepository;
import md5.exercise.ss1.bt3.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Optional<Account> findById(Integer id) {
        return accountRepository.findById(id);
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public void delete(Integer id) {
        accountRepository.deleteById(id);
    }

    @Override
    public void update(Account account) {
        accountRepository.save(account);
    }
}
