package com.exampleUserApplication.UserApplication.UserServices;

import com.exampleUserApplication.UserApplication.Exception.UserNotFoundException;
import com.exampleUserApplication.UserApplication.Model.User;
import com.exampleUserApplication.UserApplication.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServicesImp implements UserServices{

    @Autowired
    private UserRepository userRepo;
    @Override
    public User addUser(User userObj) {
        return userRepo.save(userObj);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public User updateUser(User userObj, Long id) {
        return userRepo.findById(id)
                .map(user -> {
                    user.setUserName(userObj.getUserName());
                    user.setName(userObj.getName());
                    user.setEmail(userObj.getEmail());
                    return userRepo.save(user);
                }).orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public String deleteUser(Long id) {
        if(!userRepo.existsById(id)){
            throw new UserNotFoundException(id);
        }
        userRepo.deleteById(id);
        return  "User with id "+id+" has been deleted success.";
    }
}
