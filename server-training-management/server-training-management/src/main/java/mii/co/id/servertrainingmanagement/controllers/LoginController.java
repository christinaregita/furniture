/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.servertrainingmanagement.controllers;

import mii.co.id.servertrainingmanagement.dto.LoginRequestDto;
import mii.co.id.servertrainingmanagement.dto.LoginResponseDto;
import mii.co.id.servertrainingmanagement.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ACER
 */
@RestController
@RequestMapping("login")
public class LoginController {
    
    @Autowired
    LoginService loginService;

    public LoginController() {
    }
    
    @PostMapping()
    public LoginResponseDto login(@RequestBody LoginRequestDto req) {
        return loginService.login(req);
    }
}
