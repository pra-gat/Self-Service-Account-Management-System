package com.examly.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.examly.springapp.model.UserRoleMapping;

@Service
public interface UserRoleMappingService {
  UserRoleMapping addUserRoleMapping(UserRoleMapping mapping);
  List<UserRoleMapping> getAllUserRoleMappings();
  UserRoleMapping getUserRoleMappingById(Long id);
  UserRoleMapping updateUserRoleMapping(Long id, UserRoleMapping mapping);
  List<UserRoleMapping> getUserRoleMappingsByUserId(Long userId);
  Optional<UserRoleMapping> getUserRoleMappingByUserIdAndRoleId(Long userId, Long roleId);
  void deleteUserRoleMapping(long id);
  

   
}

