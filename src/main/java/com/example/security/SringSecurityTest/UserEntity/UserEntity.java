package com.example.security.SringSecurityTest.UserEntity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import org.springframework.context.annotation.Scope;


@Entity
@Scope("prototype")
public class UserEntity {
  @Id
  private int Id;
  private String Name;
  private String Role;
  private String Password;

  public String getName() {
    return Name;
  }

  public void setName(String name) {
    Name = name;
  }

  public String getPassword() {
    return Password;
  }

  public void setPassword(String password) {
    Password = password;
  }

  public String getRole() {
    return Role;
  }

  public void setRole(String role) {
    Role = role;
  }

  public int getId() {
    return Id;
  }

  public void setId(int id) {
    Id = id;
  }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + Id +
                ", Name='" + Name + '\'' +
                ", Password='" + Password + '\'' +
                ", Role='" + Role + '\'' +
                '}';
    }

}
