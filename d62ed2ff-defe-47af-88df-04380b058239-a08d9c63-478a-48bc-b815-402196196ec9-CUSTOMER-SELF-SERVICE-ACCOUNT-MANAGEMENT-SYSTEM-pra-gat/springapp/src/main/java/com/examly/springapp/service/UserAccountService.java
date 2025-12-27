package com.examly.springapp.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.examly.springapp.model.UserAccount;

@Repository
public interface UserAccountService {
  public UserAccount postUserAccount(UserAccount userAccount);
  List<UserAccount> getAllUsers();

  UserAccount getUserById(long id);

  UserAccount updateUser(long id, UserAccount user);

  void deleteUser(long id);
  
}
