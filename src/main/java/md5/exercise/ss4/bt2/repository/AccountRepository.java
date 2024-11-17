package md5.exercise.ss4.bt2.repository;

import md5.exercise.ss4.bt2.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}
