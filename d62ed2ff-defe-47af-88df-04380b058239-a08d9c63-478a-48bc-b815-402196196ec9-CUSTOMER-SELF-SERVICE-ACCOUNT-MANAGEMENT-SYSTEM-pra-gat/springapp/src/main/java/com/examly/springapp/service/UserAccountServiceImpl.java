package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.UserAccount;
import com.examly.springapp.repository.UserAccountRepo;
@Service
public class UserAccountServiceImpl implements UserAccountService{
  @Autowired
  private UserAccountRepo userAccountRepo;

  @Override
  public UserAccount postUserAccount(UserAccount userAccount) {
    return userAccountRepo.save(userAccount);
  }

    @Override
  public List<UserAccount> getAllUsers() {
    return userAccountRepo.findAll();
  }

  @Override
  public UserAccount getUserById(long id) {
    return userAccountRepo.findById(id)
        .orElseThrow(() ->
            new RuntimeException("User not found with id: " + id));
  }

  @Override
  public UserAccount updateUser(long id, UserAccount user) {
      UserAccount existingUser = userAccountRepo.findById(id)
      .orElseThrow(() ->
          new RuntimeException("User not found with id: " + id));

    existingUser.setUsername(user.getUsername());
    existingUser.setPasswordHash(user.getPasswordHash());
    existingUser.setEmail(user.getEmail());
    existingUser.setPhone(user.getPhone());

  return userAccountRepo.save(existingUser);
  }

  @Override
  public void deleteUser(long id) {
    userAccountRepo.deleteById(id);
  }

  
}

