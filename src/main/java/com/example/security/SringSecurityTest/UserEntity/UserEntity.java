package com.example.security.SringSecurityTest.UserEntity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;

import java.lang.annotation.Documented;

@Entity
@Scope("prototype")
public class UserEntity {
  @Getter @Setter
  private String Name;
  @Getter @Setter
  private String Password;
  @Getter @Setter
  private String Role;
  @Getter @Setter
  @Id
  private int Id;

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + Id +
                ", Name='" + Name + '\'' +
                ", Email='" + Password + '\'' +
                ", Dept='" + Role + '\'' +
                '}';
    }

}
