package com.example.springapi.service.implemention;

import com.example.springapi.dto.UserDto;
import com.example.springapi.exceptions.UserNotFoundException;
import com.example.springapi.models.User;
import com.example.springapi.repository.UserRepository;
import com.example.springapi.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setAddress(userDto.getAddress());
        user.setTel(userDto.getTel());
        user.setPassword(userDto.getPassword());

        User newUser = userRepository.save(user);

        UserDto userResponse = new UserDto();
        userResponse.setId(newUser.getId());
        userResponse.setUsername(newUser.getUsername());
        userResponse.setAddress(newUser.getAddress());
        userResponse.setEmail(newUser.getEmail());
        userResponse.setTel(newUser.getTel());
        userResponse.setPassword(newUser.getPassword());

        return userResponse;
    }

    @Override
    public List<UserDto> getUsersById(int id) {
        User user =userRepository.findById(id).orElseThrow(()-> new UserNotFoundException("Utilisateur introuvable"));
        List<UserDto> userDtoList = new ArrayList<>();
        userDtoList.add(userToUserDto(user));

        return userDtoList;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();

        List<UserDto> userDtos = new ArrayList<>();
        for (User user : users) {
            UserDto userDto = new UserDto();
            userDto.setId(user.getId());
            userDto.setUsername(user.getUsername());
            userDto.setAddress(user.getAddress());
            userDto.setTel(user.getTel());
            userDto.setEmail(user.getEmail());
            userDto.setPassword(user.getPassword());

            userDtos.add(userDto);
        }

        return userDtos;
    }

    @Override
    public UserDto updateUser(int id, UserDto userDto) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();

            // Update user properties with values from userDto
            existingUser.setUsername(userDto.getUsername());
//            existingUser.setEmail(userDto.getEmail());
            existingUser.setAddress(userDto.getAddress());
            existingUser.setTel(userDto.getTel());
            existingUser.setPassword(userDto.getPassword());

            // Save the updated user
            User updatedUser = userRepository.save(existingUser);

            // Map the updatedUser to a UserDto
            UserDto updatedUserDto = new UserDto();
            updatedUserDto.setId(updatedUser.getId());
            updatedUserDto.setUsername(updatedUser.getUsername());
            updatedUserDto.setAddress(updatedUser.getAddress());
            updatedUserDto.setTel(updatedUser.getTel());
            updatedUserDto.setEmail(updatedUser.getEmail());
            updatedUserDto.setPassword(updatedUser.getPassword());

            return updatedUserDto;
        } else {
            throw new EntityNotFoundException("User with id " + id + " not found");

        }
    }

    @Override
    public boolean deleteUser(int id) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
            // User with the given id exists, so delete it
            User existingUser = optionalUser.get();
            userRepository.delete(existingUser);
        } else {
            throw new EntityNotFoundException("User with id " + id + " not found");
        }
        return false;
    }
    private UserDto userToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setAddress(user.getAddress());
        userDto.setTel(user.getTel());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        return userDto;
    }
}
