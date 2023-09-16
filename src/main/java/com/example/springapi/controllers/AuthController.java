package com.example.springapi.controllers;

import com.example.springapi.dto.RegisterDto;
import com.example.springapi.service.AuthService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthController {

    private AuthService authService;


    public AuthController (AuthService authService){
        this.authService = authService;
    }
    public String register(@RequestBody RegisterDto registerDto){
        return authService.register(registerDto);
    }


}
