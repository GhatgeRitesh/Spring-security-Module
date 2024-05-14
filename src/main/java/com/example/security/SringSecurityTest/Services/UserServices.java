package com.example.security.SringSecurityTest.Services;

import com.example.security.SringSecurityTest.Repository.UserRepository;
import com.example.security.SringSecurityTest.UserEntity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public Optional<UserEntity> findById(int Id)
    {
        return userRepository.findById(String.valueOf(Id));
    }
}
