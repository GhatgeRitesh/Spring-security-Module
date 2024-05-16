package com.example.security.SringSecurityTest.controllers;

import com.example.security.SringSecurityTest.Services.UserServices;
import com.example.security.SringSecurityTest.UserEntity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<UserEntity> saveUser(@RequestBody UserEntity myentity)
   {
       try {
           userServices.save(myentity);
           return new ResponseEntity<>(myentity, HttpStatus.CREATED);
       }catch(Exception e){
           return new ResponseEntity<>(myentity,HttpStatus.SERVICE_UNAVAILABLE);
       }
   }
   @DeleteMapping("/id/{id}")
    public ResponseEntity<UserEntity> deleteUser(@PathVariable int id )
   {
       try {
           userServices.deleteById(id);
           return new ResponseEntity<>(HttpStatus.OK);
       }catch(Exception e){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
   }
   @GetMapping("/id/{id}")
    public ResponseEntity<UserEntity> getById(@PathVariable int id)
   {
       UserEntity userEntity=userServices.findById(id);
       if(userEntity != null)
         return new ResponseEntity<>(userEntity, HttpStatus.OK);
       else
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   }
   @GetMapping("/getAll")
    public ResponseEntity<List<UserEntity>> getAll()
   {
       try {
           List<UserEntity> list = userServices.getAll();
           return new ResponseEntity<>(list, HttpStatus.OK);
       }catch(Exception e){
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       }
   }
   @PutMapping("/id/{id}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable int id,@RequestBody UserEntity newEntity)
   {
       try {
           UserEntity userEntity = userServices.findById(id);
           if (userEntity != null) {
               userEntity.setName(newEntity.getName() != null && !newEntity.getName().isEmpty() ? newEntity.getName() : userEntity.getName());
               userEntity.setRole(newEntity.getRole() != null && !newEntity.getRole().isEmpty() ? newEntity.getRole() : userEntity.getRole());
               userEntity.setPassword(newEntity.getPassword() != null && !newEntity.getPassword().isEmpty() ? newEntity.getPassword() : userEntity.getPassword());
           }
           userServices.save(userEntity);
           return new ResponseEntity<>(userEntity,HttpStatus.OK);
       }catch(Exception e){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }

   }
}