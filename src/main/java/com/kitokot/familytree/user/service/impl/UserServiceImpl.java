package com.kitokot.familytree.user.service.impl;

import com.kitokot.familytree.user.web.dto.request.ChangePasswordRequestDto;
import com.kitokot.familytree.user.web.dto.request.DeleteUserRequestDto;
import com.kitokot.familytree.user.persistence.entity.UserEntity;
import com.kitokot.familytree.user.persistence.repository.UserRepository;
import com.kitokot.familytree.user.web.dto.request.CreateUserRequestDto;
import com.kitokot.familytree.user.web.dto.response.UserResponseDto;
import com.kitokot.familytree.user.exception.CreateUserException;
import com.kitokot.familytree.user.mapper.UserMapper;
import com.kitokot.familytree.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

  private final List<String> PROHIBITED_SYMBOLS = List.of(":");

  private final UserRepository userRepository;
  private final UserMapper userMapper;

  @Override
  public UserResponseDto createUser(CreateUserRequestDto createUserRequestDto) throws CreateUserException {
    try {
      checkProhibitedSymbols(createUserRequestDto.getLogin());
      checkProhibitedSymbols(createUserRequestDto.getPassword());

      log.trace("Saving user to database");
      UserEntity userEntity = userRepository.save(userMapper.toUserEntity(createUserRequestDto));
      log.debug("User saved to database");
      return userMapper.toUserResponse(userEntity);
    } catch (DataIntegrityViolationException ex) {
      throw new CreateUserException("User already exist");
    }
  }

  private void checkProhibitedSymbols(String line) throws CreateUserException {
    if (PROHIBITED_SYMBOLS.stream().anyMatch(line::contains)) {
      log.debug("Has prohibited symbols on login/password");
      throw new CreateUserException("Login and password must not contains symbols " + PROHIBITED_SYMBOLS);
    }
  }

  @Override
  public UserResponseDto changePassword(ChangePasswordRequestDto changePasswordRequestDto) {
    return null;
  }

  @Override
  public UserResponseDto deleteUser(DeleteUserRequestDto deleteUserRequestDto) {
    return null;
  }
}
