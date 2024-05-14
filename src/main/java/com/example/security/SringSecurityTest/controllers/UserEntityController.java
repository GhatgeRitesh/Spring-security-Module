package com.example.security.SringSecurityTest.controllers;

import com.example.security.SringSecurityTest.Services.UserServices;
import com.example.security.SringSecurityTest.UserEntity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/home")
public class UserEntityController {

    @Autowired
    private final UserServices userServices;

    public UserEntityController( UserServices userServices) {
        this.userServices = userServices;
    }

   @PostMapping
    public void saveUser(@RequestBody UserEntity myentity)
   {
       userServices.save(myentity);
   }
   @DeleteMapping("/id/{id}")
    public void deleteUser(@PathVariable int id )
   {
       userServices.deleteById(id);
   }
   @GetMapping("/id/{id}")
    public Optional<UserEntity> getById(@PathVariable int id)
   {
     return userServices.findById(id);
   }

}
