package com.kitokot.familytree.controller;


import com.kitokot.familytree.dto.request.LoginRequest;
import com.kitokot.familytree.dto.response.LoginResponse;
import com.kitokot.familytree.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

  private final AuthService authService;

  @PostMapping("/login")
  public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
    String token = authService.login(request.getLogin(), request.getPassword());
    return ResponseEntity.ok(new LoginResponse(token));
  }

}
