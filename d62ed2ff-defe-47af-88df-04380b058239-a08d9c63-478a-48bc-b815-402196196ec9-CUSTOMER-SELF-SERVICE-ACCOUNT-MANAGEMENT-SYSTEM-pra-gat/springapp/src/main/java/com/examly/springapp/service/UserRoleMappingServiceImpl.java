package com.examly.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Role;
import com.examly.springapp.model.UserAccount;
import com.examly.springapp.model.UserRoleMapping;
import com.examly.springapp.repository.RoleRepo;
import com.examly.springapp.repository.UserAccountRepo;
import com.examly.springapp.repository.UserRoleMappingRepo;

@Service
public class UserRoleMappingServiceImpl implements UserRoleMappingService{
  @Autowired
  private UserRoleMappingRepo mappingRepo;

  @Autowired
  private UserAccountRepo userRepo;

  @Autowired
  private RoleRepo roleRepo;

  @Override
  public UserRoleMapping addUserRoleMapping(UserRoleMapping mapping) {
    UserRoleMapping newMapping = new UserRoleMapping();

    // resolve user
    UserAccount user = userRepo.findById(mapping.getUser().getId()).orElse(null);
    // resolve role
    Role role = roleRepo.findById(mapping.getRole().getRoleId()).orElse(null);

    newMapping.setUser(user);
    newMapping.setRole(role);

    UserRoleMapping saved = mappingRepo.save(newMapping);

    return saved;
  }


  @Override
  public List<UserRoleMapping> getAllUserRoleMappings() {
    return mappingRepo.findAll();
  }

  @Override
  public UserRoleMapping getUserRoleMappingById(Long id) {
    return mappingRepo.findById(id).orElse(null);
  }

  @Override
  public UserRoleMapping updateUserRoleMapping(Long id, UserRoleMapping mapping) {
    UserRoleMapping existing = mappingRepo.findById(id).orElse(null);
    if (existing != null) {
      existing.setUser(mapping.getUser());
      existing.setRole(mapping.getRole());
      return mappingRepo.save(existing);
    }
    return null;
  }

  @Override
  public List<UserRoleMapping> getUserRoleMappingsByUserId(Long userId) {
    return mappingRepo.findByUser_Id(userId);
  }

  @Override
  public Optional<UserRoleMapping> getUserRoleMappingByUserIdAndRoleId(
      Long userId, Long roleId) {

    List<UserRoleMapping> results =
    mappingRepo.findByUserIdAndRoleId(userId, roleId);

    if (results.isEmpty()) {
      return Optional.empty();
    }

    return Optional.of(results.get(0));
  }
  @Override
  public void deleteUserRoleMapping(long id) {
    mappingRepo.deleteById(id);
  }
}
