package com.kitokot.familytree.domain.repository;

import com.kitokot.familytree.domain.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {

  UserModel findByLogin(String login);

}
