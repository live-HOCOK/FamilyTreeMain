package com.kitokot.familytree.note.persistence.entity;

import com.kitokot.familytree.person.persistence.entity.PersonEntity;
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
@Table(name = "NOTES")
public class NoteEntity {

  @Id
  @Column(name = "NOTE_ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @JoinColumn(name = "PERSON_ID", nullable = false)
  @ManyToOne
  PersonEntity person;

  @Column(name = "NOTE", nullable = false)
  String note;

  @JoinColumn(name = "CREATION_USER")
  @ManyToOne
  UserEntity createBy;

}
