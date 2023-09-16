package com.example.springapi.controllers;

import com.example.springapi.dto.UserDto;
import com.example.springapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getUsers(){
       return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<List<UserDto>> getUserById(@PathVariable int id) {
        List<UserDto> userDto = userService.getUsersById(id);
        if (userDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userDto);
    }
    @PostMapping("/user/create")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
    }

    @PutMapping("/user/{id}/update")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable("id") int userId) {

        // userDto and userId validation
        UserDto userResponse = userService.updateUser(userId, userDto);

        if (userResponse != null) {
            return new ResponseEntity<>(userResponse, HttpStatus.OK);
        } else {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
        @DeleteMapping("/user/{id}/delete")
        public ResponseEntity<String> deleteUser(@PathVariable("id") int userId) {
            boolean deleted = userService.deleteUser(userId);

            if (deleted) {
                return new ResponseEntity<>("Utilisateur supprimé", HttpStatus.OK);
            } else {
                // Handle the case where the user with the given ID was not found
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Utilisateur non trouvé");
            }
        }
}
