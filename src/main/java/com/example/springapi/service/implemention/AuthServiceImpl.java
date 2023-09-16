package com.example.springapi.service.implemention;

import com.example.springapi.dto.RegisterDto;
import com.example.springapi.repository.UserRepository;
import com.example.springapi.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private UserRepository userRepository;
    @Override
    public String register(RegisterDto registerDto) {
        return  "Workds";
    }
}
