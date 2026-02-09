package com.kitokot.familytree.controller;

import com.kitokot.familytree.dto.request.UserRequest;
import com.kitokot.familytree.dto.response.UserResponse;
import com.kitokot.familytree.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {

  private final UserService userService;

  @PostMapping("/users")
  public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
    UserResponse userResponse = userService.createUser(userRequest);
    return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
  }

}
