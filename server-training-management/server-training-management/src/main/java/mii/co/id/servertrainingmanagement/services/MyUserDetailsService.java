/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.servertrainingmanagement.services;

import mii.co.id.servertrainingmanagement.entities.Account;
import mii.co.id.servertrainingmanagement.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    AccountRepository accountRepository;

    AuthenticationManager authenticationManager;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Account req = accountRepository.findByEmail(username);
        if (req == null) {
            throw new UsernameNotFoundException("Username tidak ditemukan");
        } else {
            return req;
        }
    }

}
