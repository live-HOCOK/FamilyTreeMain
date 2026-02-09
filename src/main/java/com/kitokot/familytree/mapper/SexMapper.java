package com.kitokot.familytree.mapper;

import com.kitokot.familytree.domain.model.SexModel;
import com.kitokot.familytree.dto.response.SexResponse;
import org.springframework.stereotype.Component;

@Component
public class SexMapper {

  public SexResponse toSexResponse(SexModel sexModel) {
    return new SexResponse(sexModel.getSexId(), sexModel.getName());
  }

}
