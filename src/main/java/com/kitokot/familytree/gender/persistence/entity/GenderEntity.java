package com.kitokot.familytree.gender.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SEX")
public class GenderEntity {

  @Column(name = "SEX_ID")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer id;

  @Column(name = "NAME", nullable = false)
  String name;

}
