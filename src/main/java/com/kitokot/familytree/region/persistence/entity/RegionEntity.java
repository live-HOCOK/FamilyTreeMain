package com.kitokot.familytree.region.persistence.entity;

import com.kitokot.familytree.country.persistence.entity.CountryEntity;
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
@Table(name = "REGIONS",
  uniqueConstraints = @UniqueConstraint(columnNames = {"NAME", "COUNTRY_ID"}))
public class RegionEntity {

  @Id
  @Column(name = "REGION_ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @Column(name = "NAME", nullable = false)
  String name;

  @JoinColumn(name = "COUNTRY_ID")
  @ManyToOne
  CountryEntity country;

}
