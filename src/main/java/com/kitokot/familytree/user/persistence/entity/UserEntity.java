package com.kitokot.familytree.user.persistence.entity;

import com.kitokot.familytree.role.persistence.entity.RoleEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
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

  @Column(name = "IS_ACTIVE", nullable = false)
  Boolean isActive;

  @JoinColumn(name = "ROLES", nullable = false)
  @ManyToOne
  RoleEntity role;

}
