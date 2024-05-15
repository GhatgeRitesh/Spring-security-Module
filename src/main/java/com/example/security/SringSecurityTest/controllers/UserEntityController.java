package com.example.security.SringSecurityTest.controllers;

import com.example.security.SringSecurityTest.Services.UserServices;
import com.example.security.SringSecurityTest.UserEntity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public UserEntity getById(@PathVariable int id)
   {
     return userServices.findById(id);
   }
   @GetMapping("/getAll")
    public List<UserEntity> getAll()
   {
       return userServices.getAll();
   }
   @PutMapping("/id/{id}")
    public UserEntity updateUser(@PathVariable int id,@RequestBody UserEntity newEntity)
   {
      UserEntity userEntity=userServices.findById(id);
      if(userEntity!=null) {
          userEntity.setName(newEntity.getName() != null && !newEntity.getName().isEmpty() ? newEntity.getName() : userEntity.getName());
          userEntity.setRole(newEntity.getRole() != null && !newEntity.getRole().isEmpty() ? newEntity.getRole() : userEntity.getRole());
          userEntity.setPassword(newEntity.getPassword()!=null && !newEntity.getPassword().isEmpty() ? newEntity.getPassword() : userEntity.getPassword());
      }
      userServices.save(userEntity);
      return userEntity;
   }
}