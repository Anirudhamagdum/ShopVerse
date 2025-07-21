package com.infosys.Account_Service.Controller;

import com.infosys.Account_Service.Entity.Account;
import com.infosys.Account_Service.Service.AccountService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
@Slf4j
public class AccountController
{
    @Autowired
    private AccountService accountService;

    @PostMapping("/register")
    public String register(@Valid @RequestBody  Account account)
    {
        return accountService.register(account);
    }

    @PostMapping("/login")
    public String login(@RequestParam String name, @RequestParam String password)
    {
        return accountService.login(name,password)? "Login Successful" : "Invalid Credentials";
    }

    @GetMapping("/checkuser")
    public boolean isRegisteredUser(@RequestParam String userName)
    {
        return accountService.isRegisteredUser(userName);
    }



}
