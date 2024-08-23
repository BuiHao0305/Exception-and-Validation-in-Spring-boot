package com.springpro.jpa.Service;

import com.springpro.jpa.Constants.UserConstants;
import com.springpro.jpa.Entity.User;
import com.springpro.jpa.Repository.UserRepository;
import com.springpro.jpa.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository UserRepository;

    public User createUser(UserDto request) {
        if(UserRepository.existsById(request.getId())) {
            throw new RuntimeException(UserConstants.ADDUSER);
        }
        User user = new User();
        user.setId(request.getId());
        user.setName(request.getName());
        user.setMark(request.getMark());
        user.setDob(request.getDob());
        return UserRepository.save(user);
    }
    public List<User> getAll() {
        return UserRepository.findAll();
    }
    public User getUserById(Integer id) {
        return UserRepository.findById(id).
                orElseThrow(()-> new RuntimeException(UserConstants.FindId));
    }
    public User updateUser(Integer id,UserDto request) {
        User user = getUserById(id);
        user.setName(request.getName());
        user.setMark(request.getMark());
        user.setDob(request.getDob());

        return UserRepository.save(user);
    }
    public void deleteUserById(Integer id) {
        UserRepository.deleteById(id);
    }
}
