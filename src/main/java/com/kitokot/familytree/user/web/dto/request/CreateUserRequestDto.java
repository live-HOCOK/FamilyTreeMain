package com.kitokot.familytree.user.web.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateUserRequestDto {

  @NotBlank(message = "Login can't have empty value")
  @Size(min = 6, max = 32)
  String login;

  @NotBlank(message = "Password can't have empty value")
  @Size(min = 6, max = 64)
  String password;

}
