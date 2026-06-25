package com.kitokot.familytree.user.web.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.annotation.JsonNaming;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ChangePasswordRequestDto {

  @NotBlank(message = "Password can't have empty value")
  @Size(min = 6, max = 64)
  String oldPassword;

  @NotBlank(message = "Password can't have empty value")
  @Size(min = 6, max = 64)
  String newPassword;

}
