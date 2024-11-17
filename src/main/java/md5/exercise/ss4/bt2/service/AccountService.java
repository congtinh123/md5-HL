package md5.exercise.ss4.bt2.service;

import md5.exercise.ss4.bt2.entity.Account;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AccountService {
    Account findById(Integer id);
    Account save(Account account);
    void delete(Integer id);
    void update(Account account);
    Page<Account> getAllAccounts(int page, int size);
    Account changeAccountStatus(Integer id, boolean status);
}
