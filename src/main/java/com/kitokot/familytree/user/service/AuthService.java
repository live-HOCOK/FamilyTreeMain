package com.kitokot.familytree.user.service;

import com.kitokot.familytree.user.exception.InvalidCredentialsException;
import com.kitokot.familytree.user.persistence.repository.UserRepository;
import com.kitokot.familytree.user.persistence.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthService {

  private final UserRepository userRepository;
  private final JwtService jwtService;


  public String login(String login, String password) {
    UserEntity user = userRepository.findByLogin(login);

    if (!password.equals(user.getPassword())) {
      throw new InvalidCredentialsException("Invalid credentials");
    }

    return jwtService.generateToken(user.getLogin());
  }
}