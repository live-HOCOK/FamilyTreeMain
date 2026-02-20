package com.kitokot.familytree.controller;

import com.kitokot.familytree.dto.request.UserRequest;
import com.kitokot.familytree.dto.response.UserResponse;
import com.kitokot.familytree.exception.user.CreateUserException;
import com.kitokot.familytree.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
public class UserController {

  private final UserService userService;

  @PostMapping("/users")
  public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequest userRequest) throws CreateUserException {
    UUID requestId = UUID.randomUUID();
    log.debug("<{}> POST /users with body:\n{}", requestId, userRequest);
    userRequest.setRequestId(requestId);
    return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userRequest));
  }

}
