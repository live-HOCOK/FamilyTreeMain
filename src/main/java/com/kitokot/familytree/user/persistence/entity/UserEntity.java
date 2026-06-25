package com.kitokot.familytree.user.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USERS",
  uniqueConstraints = @UniqueConstraint(columnNames = {"LOGIN"})
)
public class UserEntity {

  @Id
  @Column(name = "USER_ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @Column(name = "LOGIN", nullable = false)
  String login;

  @Column(name = "PASSWORD", nullable = false)
  String password;

}
