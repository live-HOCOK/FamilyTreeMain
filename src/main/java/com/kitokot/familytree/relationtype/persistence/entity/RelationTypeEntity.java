package com.kitokot.familytree.relationtype.persistence.entity;

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
@Table(name = "RELATION_TYPES",
  uniqueConstraints = @UniqueConstraint(columnNames = {"NAME"}))
public class RelationTypeEntity {

  @Id
  @Column(name = "RELATION_TYPE_ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @Column(name = "NAME", nullable = false)
  String name;

}
