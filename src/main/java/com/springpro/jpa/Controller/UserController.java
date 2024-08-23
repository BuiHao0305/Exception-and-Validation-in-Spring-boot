package com.springpro.jpa.Controller;

import com.springpro.jpa.Entity.User;
import com.springpro.jpa.Service.UserService;
import com.springpro.jpa.dto.ApiReponse;
import com.springpro.jpa.dto.UserDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/User")
    ApiReponse<User> createUser(@RequestBody @Valid UserDto request) {
        ApiReponse<User> apiResponse = new ApiReponse<>();
        apiResponse.setResult(userService.createUser(request));
        return apiResponse;
    }
    @GetMapping("/getall")
    List<User> getAllUsers() {
        return  userService.getAll();
    }
    @GetMapping("/user/{id}")
    User getUserById(@PathVariable("id") Integer userid) {
        return userService.getUserById(userid);
    }
    @PutMapping("/user/{id}")
    User updateUser(@PathVariable("id") Integer id, @RequestBody UserDto request) {
        return userService.updateUser(id, request);
    }
    @DeleteMapping("/user/{id}")
    void deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUserById(id);
    }
}
