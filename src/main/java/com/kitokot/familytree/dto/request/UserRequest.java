package com.kitokot.familytree.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.UUID;

@Data
public class UserRequest {

  UUID requestId;
  Integer id;
  @NotBlank
  @Size(min = 6, max = 32)
  String login;
  @NotBlank
  @Size(min = 6, max = 64)
  String password;

}
