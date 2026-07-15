package com.kitokot.familytree.role.service.impl;

import com.kitokot.familytree.exception.NotFoundException;
import com.kitokot.familytree.role.persistence.entity.RoleEntity;
import com.kitokot.familytree.role.persistence.repository.RoleRepository;
import com.kitokot.familytree.role.service.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {

  private final RoleRepository roleRepository;

  private final String DEFAULT_ROLE_NAME = "USER";

  @Override
  public RoleEntity getDefaultRole() {
    log.trace("Finding default role - {}", DEFAULT_ROLE_NAME);
    RoleEntity result = roleRepository.findByName(DEFAULT_ROLE_NAME)
      .orElseThrow(() -> {
        log.warn("Default role not found");
        return new NotFoundException("Default role not found");
      });
    log.trace("Default role found");
    return result;
  }
}
