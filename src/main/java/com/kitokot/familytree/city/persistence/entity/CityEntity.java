package com.kitokot.familytree.city.persistence.entity;

import com.kitokot.familytree.region.persistence.entity.RegionEntity;
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
@Table(name = "CITIES",
  uniqueConstraints = @UniqueConstraint(columnNames = {"NAME", "REGION_ID"}))
public class CityEntity {

  @Id
  @Column(name = "CITY_ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @Column(name = "NAME", nullable = false)
  String name;

  @JoinColumn(name = "REGION_ID")
  @ManyToOne
  RegionEntity region;

}
