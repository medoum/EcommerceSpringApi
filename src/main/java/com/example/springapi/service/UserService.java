package com.example.springapi.service;
import com.example.springapi.dto.UserDto;
import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);
    List<UserDto> getUsersById(int id);
    List<UserDto> getAllUsers();
    UserDto updateUser(int id, UserDto userDto);
    boolean deleteUser(int id);
}