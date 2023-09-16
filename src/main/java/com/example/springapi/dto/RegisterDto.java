package com.example.springapi.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegisterDto {

    private final String username;
    private final String password;
    private final String email;
    private final String tel;
    private final String address;
}
