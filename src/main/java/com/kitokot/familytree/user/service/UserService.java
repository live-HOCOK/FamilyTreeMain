package com.kitokot.familytree.user.service;

import com.kitokot.familytree.user.web.dto.request.ChangePasswordRequestDto;
import com.kitokot.familytree.user.web.dto.request.DeleteUserRequestDto;
import com.kitokot.familytree.user.exception.CreateUserException;
import com.kitokot.familytree.user.web.dto.request.CreateUserRequestDto;
import com.kitokot.familytree.user.web.dto.response.UserResponseDto;

public interface UserService {

  UserResponseDto createUser(CreateUserRequestDto createUserRequestDto) throws CreateUserException;

  UserResponseDto changePassword(ChangePasswordRequestDto changePasswordRequestDto);

  UserResponseDto deleteUser(DeleteUserRequestDto deleteUserRequestDto);

}
