package com.example.demo.demo.service;


import com.example.demo.demo.domain.Account;
import com.example.demo.demo.domain.Advertisement;

public interface IAccountserviceLayer {

    Account getAccount(Long accountID);
    Account saveAccount(Account newaccount);
    Account replaceAccount(Account newaccount,Long accountID );
    String deleteAccount(Long accountID);
    Account saveAdToAccount(Long accountID, Advertisement newAD);
}
