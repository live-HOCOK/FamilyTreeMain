package com.kitokot.familytree.residence.persistence.entity;

import com.kitokot.familytree.city.persistence.entity.CityEntity;
import com.kitokot.familytree.person.persistence.entity.PersonEntity;
import com.kitokot.familytree.user.persistence.entity.UserEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "RESIDENCES",
  uniqueConstraints = @UniqueConstraint(columnNames = {"PERSON_ID", "CITY_ID", "YEAR_FROM", "YEAR_TO"})
)
public class ResidenceEntity {

  @Id
  @Column(name = "RESIDENCE_ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @JoinColumn(name = "PERSON_ID", nullable = false)
  @ManyToOne
  PersonEntity person;

  @JoinColumn(name = "CITY_ID", nullable = false)
  @ManyToOne
  CityEntity city;

  @Column(name = "YEAR_FROM")
  Integer from;

  @Column(name = "YEAR_TO")
  Integer to;

  @Column(name = "IS_APPROXIMATE")
  Boolean isApproximate;

  @JoinColumn(name = "CREATION_USER")
  @ManyToOne
  UserEntity createBy;

}
