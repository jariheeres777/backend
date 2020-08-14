package com.example.demo.demo;/*
package com.example.demo;

import com.example.demo.domain.Account;
import com.example.demo.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
public class DatabaseLoader implements CommandLineRunner {

    @Autowired
    private AccountRepository playerRepositor;

    public DatabaseLoader(AccountRepository playerRepository){
        this.playerRepositor= playerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Account account1= new Account("jari");
        playerRepositor.save(account1);

        Account account2= new Account("dennis");
        playerRepositor.save(account2);
    }
}
*/
