package com.kitokot.familytree.birthdate.persistence.entity;

import com.kitokot.familytree.person.persistence.entity.PersonEntity;
import com.kitokot.familytree.user.persistence.entity.UserEntity;
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
@Table(name = "BIRTH_DATES",
  uniqueConstraints = @UniqueConstraint(columnNames = {"PERSON_ID", "DAY", "MONTH", "YEAR"}))
public class BirthDateEntity {

  @Id
  @Column(name = "BIRTH_DATE_ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @JoinColumn(name = "PERSON_ID", nullable = false)
  @ManyToOne
  PersonEntity person;

  @Column(name = "DAY")
  Short day;

  @Column(name = "MONTH")
  Short month;

  @Column(name = "YEAR")
  Integer year;

  @Column(name = "IS_APPROXIMATE")
  Boolean isApproximate;

  @JoinColumn(name = "CREATION_USER")
  @ManyToOne
  UserEntity createBy;

}
