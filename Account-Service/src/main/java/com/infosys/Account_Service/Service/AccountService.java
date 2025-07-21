package com.infosys.Account_Service.Service;
import com.infosys.Account_Service.Entity.Account;
import com.infosys.Account_Service.Feign.ProductClient;
import com.infosys.Account_Service.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService
{
    @Autowired
    private AccountRepository repo;

    @Autowired
    private ProductClient productClient;

    public String register(Account account)
    {
        if(repo.existsById(account.getName()))
        {
            return "Username Already Exists!";
        }
        if(repo.findByEmail(account.getEmail()).isPresent())
        {
            return "Email Already In Use!";
        }
        if(!account.getPassword().equals(account.getConfirmPassword()))
        {
            return "Password Do Not Match!";
        }
        if(!isValidPassword(account.getPassword()))
        {
            return "Password must contain at least an uppercase and a lowercase character, a number and a special character";
        }

        repo.save(account);
        String response = productClient.notifyProductService(account.getName());
        return "Registration Successful. "+response;
    }

    private boolean isValidPassword(String pwd) {
        return pwd.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,}$");
    }

    public boolean login(String name, String password)
    {
        return repo.findByNameAndPassword(name,password).isPresent();
    }

    public boolean isRegisteredUser(String name)
    {
        return repo.findByName(name).isPresent();
    }
}
