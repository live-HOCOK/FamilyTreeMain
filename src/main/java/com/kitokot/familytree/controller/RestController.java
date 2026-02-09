package com.kitokot.familytree.controller;

import com.kitokot.familytree.domain.dao.SexRepository;
import com.kitokot.familytree.domain.model.SexModel;
import com.kitokot.familytree.dto.response.SexResponse;
import com.kitokot.familytree.mapper.SexMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@org.springframework.web.bind.annotation.RestController
public class RestController {

  private final SexRepository sexRepository;
  private final SexMapper sexMapper;

  @GetMapping(value = "/sex")
  public SexResponse getSex(@RequestParam int id) {

    SexModel sexModel = sexRepository.getSexBySexId(id);
    SexResponse sexResponse = sexMapper.toSexResponse(sexModel);
    return sexResponse;

  }

}
