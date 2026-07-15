package com.kitokot.familytree.namehistory.persistence.entity;

import com.kitokot.familytree.person.persistence.entity.PersonEntity;
import com.kitokot.familytree.user.persistence.entity.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "NAME_HISTORIES",
  uniqueConstraints = @UniqueConstraint(columnNames =
    {"PERSON_ID", "OLD_FIRST_NAME", "OLD_SECOND_NAME", "OLD_SURNAME"}))
public class NameHistoryEntity {

  @Id
  @Column(name = "NAME_HIST_ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @JoinColumn(name = "PERSON_ID", nullable = false)
  @ManyToOne
  PersonEntity person;

  @Column(name = "OLD_FIRST_NAME")
  String oldFirstName;

  @Column(name = "OLD_SECOND_NAME")
  String oldSecondName;

  @Column(name = "OLD_SURNAME")
  String oldSurname;

  @Column(name = "CHANGE_DATE")
  LocalDate changeDate;

  @JoinColumn(name = "CREATION_USER")
  @ManyToOne
  UserEntity createBy;

}
