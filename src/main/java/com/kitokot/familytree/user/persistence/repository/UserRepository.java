package com.kitokot.familytree.user.persistence.repository;

import com.kitokot.familytree.user.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

  UserEntity findByLogin(String login);

}
