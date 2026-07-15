package com.kitokot.familytree.country.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "COUNTRIES",
  uniqueConstraints = @UniqueConstraint(columnNames = {"NAME"}))
public class CountryEntity {

  @Id
  @Column(name = "COUNTRY_ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer id;

  @Column(name = "NAME", nullable = false)
  String name;

}
