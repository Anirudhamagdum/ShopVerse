package com.infosys.Account_Service.Repository;
import com.infosys.Account_Service.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,String>
{
    Optional<Account> findByEmail(String email);
    Optional<Account>findByNameAndPassword(String name, String password);
    Optional<Account> findByName(String name);
}
