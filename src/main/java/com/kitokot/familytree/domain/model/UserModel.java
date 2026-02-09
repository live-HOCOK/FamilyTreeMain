package com.kitokot.familytree.domain.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "USERS",
  uniqueConstraints = @UniqueConstraint(columnNames = {"LOGIN"})
)
public class UserModel {

  @Id
  @Column(name = "USER_ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer id;

  @Column(name = "LOGIN", nullable = false)
  String login;

  @Column(name = "PASSWORD", nullable = false)
  String password;

}
