package com.kitokot.familytree.user.web.dto.request;

import lombok.Data;
import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class DeleteUserRequestDto {

  Long userId;

}
