package com.kitokot.familytree.country.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class CountryEntity {

  @Id
  @Column(name = "COUNTRY_ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer id;

  @Column(name = "NAME")
  String name;

}
