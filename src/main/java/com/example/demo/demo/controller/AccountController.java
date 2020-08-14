package com.example.demo.demo.controller;


import com.example.demo.demo.domain.Account;
import com.example.demo.demo.domain.Advertisement;
import com.example.demo.demo.service.IAccountserviceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class AccountController {

    @Autowired
    private IAccountserviceLayer AplicationserviceLayer;

    @GetMapping(value = "/api/account/{accountID}")
    public Account getAccount(@PathVariable Long accountID) {
        return AplicationserviceLayer.getAccount(accountID);
    }

    @PostMapping(value = "/api/account")
    public Account saveAccount(@RequestBody Account newaccount) {
        return AplicationserviceLayer.saveAccount(newaccount);
    }


    @DeleteMapping(value = "/api/account/{accountID}")
    public String deleteAccount(@PathVariable Long accountID) {
        return AplicationserviceLayer.deleteAccount(accountID);
    }

    @PutMapping(value = "/api/account/{accountID}")
    public Account replaceAccount(@RequestBody Account newaccount, @PathVariable Long accountID) {
        return AplicationserviceLayer.replaceAccount(newaccount, accountID);
    }

    @PutMapping(value = "/api/account/{accountID}/Advertisement")
    public Account saveAdToAccount(@RequestBody Advertisement newAD, @PathVariable Long accountID) {
        return AplicationserviceLayer.saveAdToAccount(accountID, newAD);
    }
}