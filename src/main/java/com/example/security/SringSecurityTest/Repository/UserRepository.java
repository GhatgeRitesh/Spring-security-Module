package com.example.security.SringSecurityTest.Repository;

import com.example.security.SringSecurityTest.UserEntity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface UserRepository extends CrudRepository<UserEntity,String> {
}
