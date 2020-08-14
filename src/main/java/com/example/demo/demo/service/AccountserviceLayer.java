package com.example.demo.demo.service;


import com.example.demo.demo.Repository.AccountRepository;
import com.example.demo.demo.domain.Account;
import com.example.demo.demo.domain.Advertisement;
import com.example.demo.demo.exception.AccountNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class AccountserviceLayer implements IAccountserviceLayer {


    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account getAccount(Long accountID) {
        return accountRepository.findById(accountID)
                .orElseThrow(() -> new AccountNotFoundException(accountID));
    }

    @Override
    public Account saveAccount(Account newaccount)
    {
        return accountRepository.save(newaccount);
    }

    @Override
    public String deleteAccount(Long accountID) {
        Optional<Account> account = accountRepository.findById(accountID);
        if (account.isPresent()) {
            accountRepository.deleteById(accountID);
            return "user me id " + account.get().getAccountID() + " is deleted";
        }
        throw new AccountNotFoundException("User not found");
    }

    @Override
    public Account replaceAccount(Account newaccount, Long accountID) {
        return accountRepository.findById(accountID).map(Account -> {
            Account.setUsername(newaccount.getUsername());
            Account.setEmail(newaccount.getEmail());
            Account.setPassword(newaccount.getPassword());
            return accountRepository.save(Account);
        }).orElseGet(() -> {
            newaccount.setAccountID(accountID);
            return accountRepository.save(newaccount);
        });
    }

    @Override
    public Account saveAdToAccount(Long accountID, Advertisement newAD) {
        Optional<Account> user =
                accountRepository.findById(accountID);

        if (user.isPresent()) {
            Account userFromDb = user.get();
            List<Advertisement> currentAds = userFromDb.getAds();

            if (newAD.getUser() == null || newAD.getUser().getAccountID() != accountID) {
                newAD.setUser(userFromDb);
            }

            currentAds.add(newAD);
            userFromDb.setAds(currentAds);

            return accountRepository.save(userFromDb);
        }
        throw new AccountNotFoundException(accountID);
    }

}
