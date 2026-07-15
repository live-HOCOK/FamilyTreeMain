package com.kitokot.familytree.relationhistory.persistence.entity;

import com.kitokot.familytree.relation.persistence.entity.RelationEntity;
import com.kitokot.familytree.user.persistence.entity.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "RELATION_HISTORIES",
  uniqueConstraints = @UniqueConstraint(columnNames =
    {"RELATION_ID", "START_DATE", "END_DATE"}))
public class RelationHistoryEntity {

  @Id
  @Column(name = "RELATION_HIST_ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @JoinColumn(name = "RELATION_ID", nullable = false)
  @ManyToOne
  RelationEntity relation;

  @Column(name = "START_DATE")
  LocalDate startDate;

  @Column(name = "END_DATE")
  LocalDate endDate;

  @Column(name = "IS_APPROXIMATE")
  Boolean isApproximate;

  @JoinColumn(name = "CREATION_USER")
  @ManyToOne
  UserEntity createBy;

}
