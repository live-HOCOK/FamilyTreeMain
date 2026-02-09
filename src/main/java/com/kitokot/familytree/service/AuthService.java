package com.kitokot.familytree.service;

import com.kitokot.familytree.domain.dao.UserRepository;
import com.kitokot.familytree.domain.model.UserModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthService {

  private final UserRepository userRepository;
  private final JwtService jwtService;


  public String login(String login, String password) {
    UserModel user = userRepository.findByLogin(login);

    if (!password.equals(user.getPassword())) {
      throw new RuntimeException("Invalid credentials");
    }

    return jwtService.generateToken(user.getLogin());
  }
}