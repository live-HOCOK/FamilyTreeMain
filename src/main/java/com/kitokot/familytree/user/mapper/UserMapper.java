package com.kitokot.familytree.user.mapper;

import com.kitokot.familytree.role.service.RoleService;
import com.kitokot.familytree.user.persistence.entity.UserEntity;
import com.kitokot.familytree.user.web.dto.request.CreateUserRequestDto;
import com.kitokot.familytree.user.web.dto.response.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserMapper {

  private final RoleService roleService;

  public UserEntity toUserEntity(CreateUserRequestDto createUserRequestDto) {
    UserEntity userEntity = new UserEntity();
    userEntity.setLogin(createUserRequestDto.getLogin());
    userEntity.setPassword(createUserRequestDto.getPassword());
    userEntity.setRole(roleService.getDefaultRole());
    userEntity.setIsActive(true);
    return userEntity;
  }

  public UserResponseDto toUserResponse(UserEntity userEntity) {
    UserResponseDto userResponseDto = new UserResponseDto();
    userResponseDto.setId(userEntity.getId());
    userResponseDto.setLogin(userEntity.getLogin());
    return userResponseDto;
  }

}
