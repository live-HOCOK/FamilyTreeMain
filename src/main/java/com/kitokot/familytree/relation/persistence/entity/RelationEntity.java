package com.kitokot.familytree.relation.persistence.entity;

import com.kitokot.familytree.person.persistence.entity.PersonEntity;
import com.kitokot.familytree.relationtype.persistence.entity.RelationTypeEntity;
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
@Table(name = "RELATIONS",
  uniqueConstraints = @UniqueConstraint(columnNames = {"FIRST_PERSON_ID", "SECOND_PERSON_ID"}))
public class RelationEntity {

  @Id
  @Column(name = "RELATION_ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @JoinColumn(name = "FIRST_PERSON_ID", nullable = false)
  @ManyToOne
  PersonEntity firstPerson;

  @JoinColumn(name = "SECOND_PERSON_ID", nullable = false)
  @ManyToOne
  PersonEntity secondPerson;

  @JoinColumn(name = "RELATION_TYPE_ID", nullable = false)
  @ManyToOne
  RelationTypeEntity relationType;

  @JoinColumn(name = "CREATION_USER")
  @ManyToOne
  UserEntity createBy;

}
