package com.kitokot.familytree.mapper;

import com.kitokot.familytree.domain.model.UserModel;
import com.kitokot.familytree.dto.request.UserRequest;
import com.kitokot.familytree.dto.response.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

  public UserModel toUserModel(UserRequest userRequest) {
    UserModel userModel = new UserModel();
    userModel.setId(userRequest.getId());
    userModel.setLogin(userRequest.getLogin());
    userModel.setPassword(userRequest.getPassword());
    return userModel;
  }

  public UserResponse toUserResponse(UserModel userModel) {
    UserResponse userResponse = new UserResponse();
    userResponse.setId(userModel.getId());
    userResponse.setLogin(userModel.getLogin());
    return userResponse;
  }

}
