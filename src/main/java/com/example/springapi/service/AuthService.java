package com.example.springapi.service;

import com.example.springapi.dto.RegisterDto;


public interface AuthService {
    String register(RegisterDto registerDto);
}
