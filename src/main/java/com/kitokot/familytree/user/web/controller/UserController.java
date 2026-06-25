package com.kitokot.familytree.user.web.controller;

import com.kitokot.familytree.user.web.dto.request.CreateUserRequestDto;
import com.kitokot.familytree.user.web.dto.response.UserResponseDto;
import com.kitokot.familytree.user.exception.CreateUserException;
import com.kitokot.familytree.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class UserController {

  private final UserService userService;

  @PostMapping("/users")
  public ResponseEntity<UserResponseDto> createUser(@Valid @RequestBody CreateUserRequestDto createUserRequestDto) throws CreateUserException {
    log.debug("POST /users with body:\n{}", createUserRequestDto);
    return ResponseEntity
      .status(HttpStatus.CREATED)
      .body(userService.createUser(createUserRequestDto));
  }

}
