package com.kitokot.familytree.service;

import com.kitokot.familytree.domain.dao.UserRepository;
import com.kitokot.familytree.dto.request.UserRequest;
import com.kitokot.familytree.dto.response.UserResponse;
import com.kitokot.familytree.mapping.UserMapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

  private final UserRepository userRepository;
  private final UserMapping userMapping;

  public UserResponse createUser(UserRequest userRequest) {
    return userMapping.toUserResponse(userRepository.save(userMapping.toUserModel(userRequest)));
  }

  public UserResponse changePassword(UserRequest userRequest) {
    return null;
  }
}
