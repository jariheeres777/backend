package com.example.demo.demo.service;


import com.example.demo.demo.Repository.AccountRepository;
import com.example.demo.demo.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    AccountRepository accountRepository;

    @Autowired
    public UserDetailsServiceImpl(AccountRepository userRepository) {
        this.accountRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username)  {
        Account account = accountRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found: " + username));
        return UserDetailsImpl.build(account);
    }
}
