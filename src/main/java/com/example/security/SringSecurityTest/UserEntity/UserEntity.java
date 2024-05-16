package com.example.security.SringSecurityTest.UserEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.stereotype.Indexed;


@Entity
@Table(name="Users")
@Getter @Setter
public class UserEntity {
  @Id
  private int Id;
  @Column(unique = true)
  @NonNull
  private String Name;
  @NonNull
  private String Role;
  @NonNull
  private String Password;
}