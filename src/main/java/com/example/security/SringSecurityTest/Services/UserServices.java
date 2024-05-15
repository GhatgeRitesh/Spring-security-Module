package com.example.security.SringSecurityTest.Services;

import com.example.security.SringSecurityTest.Repository.UserRepository;
import com.example.security.SringSecurityTest.UserEntity.UserEntity;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServices {
    @Autowired
    private final UserRepository userRepository;

    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public void save(UserEntity user)
    {
        userRepository.save(user);
    }
    public void deleteById(int Id)
    {
        userRepository.deleteById(String.valueOf(Id));
    }
    public UserEntity findById(int Id)
    {
        Optional<UserEntity> userEntity= userRepository.findById(String.valueOf(Id));
        return userEntity.orElse(null);
    }
    public List<UserEntity> getAll()
    {
        List<UserEntity> userList = new ArrayList<>();
        userRepository.findAll().forEach(userList::add);
        return userList;
    }
    public void updateUser(UserEntity userEntity)
    {
        userRepository.save(userEntity);
    }
}
