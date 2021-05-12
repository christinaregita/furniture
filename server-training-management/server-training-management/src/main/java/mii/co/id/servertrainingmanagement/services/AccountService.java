/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.servertrainingmanagement.services;

import mii.co.id.servertrainingmanagement.dto.AccountRegisterDto;
import mii.co.id.servertrainingmanagement.entities.Account;
import mii.co.id.servertrainingmanagement.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service
public class AccountService {
    
    @Autowired
    AccountRepository accountRepository;
    
    @Autowired
    PasswordEncoder passwordEncoder;

    public AccountService() {
    }
    
    //Create account for existing employee
    public boolean register(AccountRegisterDto registerDto) {
        Account account = new Account(
                registerDto.getId(), 
                registerDto.getEmail(), 
                passwordEncoder.encode(registerDto.getPassword()), 
                0);
        accountRepository.save(account);
        return accountRepository.existsById(registerDto.getId());
    }
    
    public Account getById(Integer id) {
        return accountRepository.findById(id).get();
    }
    
    public Integer getIdByUsername(String username) {
        return accountRepository.findByEmail(username).getId();
    }
}
