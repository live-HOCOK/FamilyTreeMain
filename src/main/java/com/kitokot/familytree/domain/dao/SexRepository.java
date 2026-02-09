package com.kitokot.familytree.domain.dao;

import com.kitokot.familytree.domain.model.SexModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SexRepository extends JpaRepository<SexModel, Integer> {

  SexModel getSexBySexId(int id);

}
