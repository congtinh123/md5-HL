package md5.exercise.ss4.bt2.serviceimpl;
import md5.exercise.ss4.bt2.entity.Account;
import md5.exercise.ss4.bt2.repository.AccountRepository;
import md5.exercise.ss4.bt2.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account findById(Integer id) {
        return accountRepository.findById(id).orElse(null);
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
    public void update(Account account){
        accountRepository.save(account);
    }

    @Override
    public Page<Account> getAllAccounts(int page, int size) {
        return accountRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Account changeAccountStatus(Integer id, boolean status) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Account not found"));
        account.setStatus(status);
        return accountRepository.save(account);
    }
}
