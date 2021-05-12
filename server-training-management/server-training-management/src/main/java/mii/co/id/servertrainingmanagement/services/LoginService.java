/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.servertrainingmanagement.services;

import java.util.ArrayList;
import java.util.List;
import mii.co.id.servertrainingmanagement.dto.LoginRequestDto;
import mii.co.id.servertrainingmanagement.dto.LoginResponseDto;
import mii.co.id.servertrainingmanagement.entities.Account;
import mii.co.id.servertrainingmanagement.entities.Privilege;
import mii.co.id.servertrainingmanagement.entities.Role;
import mii.co.id.servertrainingmanagement.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service
public class LoginService {
    
    @Autowired
    AccountRepository accountRepository;
    
    public LoginResponseDto login(LoginRequestDto req) {
        BCryptPasswordEncoder b = new BCryptPasswordEncoder();
        Account account = accountRepository.findByEmail(req.getUsername());
        if (account == null) {
            throw new UsernameNotFoundException("Username tidak ditemukan");
        } else {
            if (b.matches(req.getPassword(), account.getPassword())) {
                List<Role> roleList = account.getRoleList();
                List<String> auth = new ArrayList<>();
                for (Role r : roleList) {
                    auth.add("ROLE_" + r.getName().toUpperCase());
                    List<Privilege> privileges = r.getPrivilegeList();
                    for (Privilege p : privileges) {
                        auth.add(p.getName().toUpperCase());
                    }
                }
                UsernamePasswordAuthenticationToken authToken
                        = new UsernamePasswordAuthenticationToken(
                                account.getUsername(), account.getPassword(), account.getAuthorities());
                authToken.setDetails(account.getId());
                SecurityContextHolder.getContext().setAuthentication(authToken);
                System.out.println("login berhasil");
                return new LoginResponseDto(account.getId(), account.getEmployee().getName(), auth);
            } else {
                throw new UsernameNotFoundException("login gagal, password salah");
            }
        }
    }
}
