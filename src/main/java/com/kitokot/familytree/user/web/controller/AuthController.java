package com.kitokot.familytree.user.web.controller;


import com.kitokot.familytree.user.web.dto.request.LoginRequestDto;
import com.kitokot.familytree.user.web.dto.response.LoginResponseDto;
import com.kitokot.familytree.user.service.AuthService;
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
  public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto request) {
    String token = authService.login(request.getLogin(), request.getPassword());
    return ResponseEntity.ok(new LoginResponseDto(token));
  }

}
