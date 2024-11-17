package md5.exercise.ss1.bt3.repository;
import md5.exercise.ss1.bt3.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
}
