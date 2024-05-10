package com.exampleUserApplication.UserApplication.Controller;

import com.exampleUserApplication.UserApplication.Exception.UserNotFoundException;
import com.exampleUserApplication.UserApplication.Model.User;
import com.exampleUserApplication.UserApplication.Repository.UserRepository;
import com.exampleUserApplication.UserApplication.UserServices.UserServices;
import com.exampleUserApplication.UserApplication.UserServices.UserServicesImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//@RequestMapping("/userApp")
@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {

    //private UserRepository userRepo;
    @Autowired
    UserServices userServ;

    @PostMapping("/user")
    User newUser(@RequestBody User newUser) {
        return userServ.addUser(newUser);
        //return userRepo.save(newUser);
    }

    @GetMapping("/users")
    List<User> getAllUsers() {
        return userServ.getAllUsers();
        //return userRepo.findAll();
    }

    @GetMapping("/user/{id}")
    User getUserById(@PathVariable Long id) {
        return  userServ.getUserById(id);
        //return userRepo.findById(id)
          //      .orElseThrow(() -> new UserNotFoundException(id));
    }

    @PutMapping("/user/{id}")
    User updateUser(@RequestBody User newUser, @PathVariable Long id) {
        return  userServ.updateUser(newUser, id);
//        return userRepo.findById(id)
//                .map(user -> {
//                    user.setUserName(newUser.getUserName());
//                    user.setName(newUser.getName());
//                    user.setEmail(newUser.getEmail());
//                    return userRepo.save(user);
//                }).orElseThrow(() -> new UserNotFoundException(id));
    }

    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Long id){

        return userServ.deleteUser(id);
//        if(!userRepo.existsById(id)){
//            throw new UserNotFoundException(id);
//        }
//        userRepo.deleteById(id);
//        return  "User with id "+id+" has been deleted success.";
    }
//    @PostMapping("/user")
//    User newUser(@RequestBody User newUser) {
//        return userServ.addUser(newUser);
//    }
//
//    @GetMapping("/users")
//    List<User> getAllUsers() {
//        return userServ.getAllUsers();
//    }
//
//    @GetMapping("/user/{id}")
//    User getUserById(@PathVariable Long id) {
//        return userServ.getUserById(id);
//
//    }
//
//    @PutMapping("/user/{id}")
//    User updateUser(@RequestBody User newUser, @PathVariable Long id) {
//        return userServ.updateUser(newUser, id);
//    }
//
//    @DeleteMapping("/user/{id}")
//    String deleteUser(@PathVariable Long id){
//        return userServ.deleteUser(id);
//    }
}
