package com.kitokot.familytree.user.mapper;

import com.kitokot.familytree.user.persistence.entity.UserEntity;
import com.kitokot.familytree.user.web.dto.request.CreateUserRequestDto;
import com.kitokot.familytree.user.web.dto.response.UserResponseDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

  public UserEntity toUserModel(CreateUserRequestDto createUserRequestDto) {
    UserEntity userEntity = new UserEntity();
    userEntity.setId(createUserRequestDto.getId());
    userEntity.setLogin(createUserRequestDto.getLogin());
    userEntity.setPassword(createUserRequestDto.getPassword());
    return userEntity;
  }

  public UserResponseDto toUserResponse(UserEntity userEntity) {
    UserResponseDto userResponseDto = new UserResponseDto();
    userResponseDto.setId(userEntity.getId());
    userResponseDto.setLogin(userEntity.getLogin());
    return userResponseDto;
  }

}
