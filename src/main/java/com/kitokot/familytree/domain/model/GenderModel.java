package com.kitokot.familytree.domain.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "SEX")
public class GenderModel {

  @Column(name = "SEX_ID")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  int genderId;

  @Column(name = "NAME", nullable = false)
  String name;

}
