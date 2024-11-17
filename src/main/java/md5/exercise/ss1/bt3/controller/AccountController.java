package md5.exercise.ss1.bt3.controller;

import md5.exercise.ss1.bt3.entity.Account;
import md5.exercise.ss1.bt3.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/ss1/baitap3")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping
    public String listAccount(Model model) {
        List<Account> accounts = accountService.findAll();
        model.addAttribute("accounts", accounts);
        return "ss1/bt3/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("account", new Account());
        return "ss1/bt3/add";
    }

    @PostMapping("/add")
    public String addAccount(@ModelAttribute Account account) {
        accountService.save(account);
        return "redirect:/ss1/baitap3";
    }

    @GetMapping("/edit/{accountId}")
    public String showEditForm(@PathVariable Integer accountId, Model model) {
        Optional<Account> account = accountService.findById(accountId);
        if (account.isPresent()) {
            model.addAttribute("account", account.get());
        } else {
            return "redirect:/ss1/baitap3"; // chuyển hướng về danh sách nhân viên
        }

        return "ss1/bt3/edit";
    }

    @PostMapping("/edit")
    public String editAccount(@ModelAttribute Account account) {
        accountService.update(account);
        return "redirect:/ss1/baitap3"; // chuyển hướng về danh sách nhân viên
    }


    @GetMapping("/delete/{accountId}")
    public String deleteAccount(@PathVariable Integer accountId) {
        accountService.delete(accountId);
        return "redirect:/ss1/baitap3"; // Chuyển hướng về danh sách nhân viên
    }
}
