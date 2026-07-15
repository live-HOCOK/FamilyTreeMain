package com.kitokot.familytree.role.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ROLES",
  uniqueConstraints = @UniqueConstraint(columnNames = {"NAME"})
)
public class RoleEntity {

  @Id
  @Column(name = "ROLE_ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @Column(name = "NAME", nullable = false)
  String name;

  @Column(name = "CREATE", nullable = false)
  Boolean isCreate;

  @Column(name = "DELETE", nullable = false)
  Boolean isDelete;

  @Column(name = "UPDATE", nullable = false)
  Boolean isUpdate;

  @Column(name = "USER_CREATE", nullable = false)
  Boolean isUserCreate;

  @Column(name = "USER_DELETE", nullable = false)
  Boolean isUserDelete;

  @Column(name = "USER_UPDATE", nullable = false)
  Boolean isUserUpdate;
}
