package com.kitokot.familytree.birthplace.persistence.entity;

import com.kitokot.familytree.city.persistence.entity.CityEntity;
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
@Table(name = "BIRTH_PLACES",
  uniqueConstraints = @UniqueConstraint(columnNames = {"PERSON_ID", "CITY_ID"}))
public class BirthPlaceEntity {

  @Id
  @Column(name = "BIRTH_PLACE_ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @JoinColumn(name = "PERSON_ID", nullable = false)
  @ManyToOne
  PersonEntity person;

  @JoinColumn(name = "CITY_ID", nullable = false)
  @ManyToOne
  CityEntity city;

  @Column(name = "IS_APPROXIMATE")
  Boolean isApproximate;

  @JoinColumn(name = "CREATION_USER")
  @ManyToOne
  UserEntity createBy;

}
