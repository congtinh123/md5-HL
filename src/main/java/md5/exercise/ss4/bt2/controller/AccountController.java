package md5.exercise.ss4.bt2.controller;

import md5.exercise.ss4.bt2.entity.Account;
import md5.exercise.ss4.bt2.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @GetMapping
    public ResponseEntity<List<Account>> findAll(@RequestParam int page,
                                                 @RequestParam int size){
        List<Account> getAll = accountService.getAllAccounts(page, size).getContent();
        return ResponseEntity.ok(getAll);
    }

    @PostMapping
    public ResponseEntity<Account> addAccount(@RequestBody Account account){
        Account newAccount = accountService.save(account);
        return ResponseEntity.ok(newAccount);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable Integer id, @RequestBody Account account){
        account.setAccountId(id);
        Account updatedAccount = accountService.save(account);
        return ResponseEntity.ok(updatedAccount);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Account> deleteAccount(@PathVariable Integer id){
        accountService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> findById(@PathVariable Integer id){
        Account account = accountService.findById(id);
        return ResponseEntity.ok(account);
    }
}
