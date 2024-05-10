package com.exampleUserApplication.UserApplication.UserServices;

import com.exampleUserApplication.UserApplication.Model.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserServices {


    public User addUser(User userObj);
    public List<User> getAllUsers();
    public  User getUserById(Long id);
    public User updateUser(User userObj, Long id);
    public String deleteUser(Long id);

}
