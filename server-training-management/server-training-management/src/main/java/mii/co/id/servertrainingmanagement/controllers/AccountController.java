/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.servertrainingmanagement.controllers;

import mii.co.id.servertrainingmanagement.dto.AccountRegisterDto;
import mii.co.id.servertrainingmanagement.entities.Account;
import mii.co.id.servertrainingmanagement.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ACER
 */
@RestController
@RequestMapping("/api/account")
public class AccountController {
    
    @Autowired
    AccountService accountService;

    public AccountController() {
    }
    
    @GetMapping("/{id}")
    public Account getById(@PathVariable Integer id) {
        return accountService.getById(id);
    }
    
    @GetMapping("/{username}")
    public Integer getIdByUsername(@PathVariable String username) {
        return accountService.getIdByUsername(username);
    }
    
    //Register account
    @PostMapping()
    public Boolean register(@RequestBody AccountRegisterDto registerDto) {
        return accountService.register(registerDto);
    }
    
}
