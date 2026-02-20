package com.kitokot.familytree.service;

import com.kitokot.familytree.domain.model.UserModel;
import com.kitokot.familytree.domain.repository.UserRepository;
import com.kitokot.familytree.dto.request.UserRequest;
import com.kitokot.familytree.dto.response.UserResponse;
import com.kitokot.familytree.exception.user.CreateUserException;
import com.kitokot.familytree.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {

  private final List<String> PROHIBITED_SYMBOLS = List.of(":");

  private final UserRepository userRepository;
  private final UserMapper userMapper;


  public UserResponse createUser(UserRequest userRequest) throws CreateUserException {
    try {
      checkCredentialSymbols(userRequest.getRequestId(), userRequest.getLogin());
      checkCredentialSymbols(userRequest.getRequestId(), userRequest.getPassword());

      log.trace("<{}> Saving user to database", userRequest.getRequestId());
      UserModel userModel = userRepository.save(userMapper.toUserModel(userRequest));
      log.debug("<{}> User saved to database", userRequest.getRequestId());
      return userMapper.toUserResponse(userModel);
    } catch (DataIntegrityViolationException ex) {
      throw new CreateUserException("User already exist");
    }
  }

  private void checkCredentialSymbols(UUID requestId, String line) throws CreateUserException {
    log.trace("<{}> Check login/password on null values", requestId);
    if (Objects.isNull(line) || line.isEmpty()) {
      log.debug("<{}> Has null values on login/password>", requestId);
      throw new CreateUserException("Login and password must not have nul values");
    }
    log.trace("<{}> Check login/password on prohibited symbols", requestId);
    if (PROHIBITED_SYMBOLS.stream().anyMatch(line::contains)) {
      log.debug("<{}> Has prohibited symbols on login/password>", requestId);
      throw new CreateUserException("Login and password must not contains symbols " + PROHIBITED_SYMBOLS);
    }
  }

  public UserResponse changePassword(UserRequest userRequest) {
    return null;
  }
}
