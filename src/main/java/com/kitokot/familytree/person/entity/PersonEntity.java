package com.kitokot.familytree.person.entity;

import com.kitokot.familytree.gender.persistence.entity.GenderEntity;
import com.kitokot.familytree.user.persistence.entity.UserEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PERSONS")
public class PersonEntity {

  @Id
  @Column(name = "PERSON_ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @JoinColumn(name = "SEX_ID")
  @ManyToOne
  GenderEntity genderId;

  @Column(name = "FIRST_NAME")
  String firstName;

  @Column(name = "SECOND_NAME")
  String secondName;

  @Column(name = "SURNAME")
  String surname;

  @JoinColumn(name = "CREATION_USER")
  @ManyToOne
  UserEntity createBy;

}
