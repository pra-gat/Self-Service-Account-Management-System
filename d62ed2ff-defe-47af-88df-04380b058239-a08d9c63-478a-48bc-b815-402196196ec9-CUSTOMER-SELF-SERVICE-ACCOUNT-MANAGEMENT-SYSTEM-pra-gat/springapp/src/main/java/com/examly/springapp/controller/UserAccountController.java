package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.UserAccount;
import com.examly.springapp.service.UserAccountService;

@RestController
@RequestMapping("/api/users")
public class UserAccountController {
  @Autowired
  private UserAccountService userService;

  @PostMapping
  public UserAccount postUserAccount(@RequestBody UserAccount userAccount){
    return userService.postUserAccount(userAccount);
  }
  @GetMapping
  public ResponseEntity<List<UserAccount>> getAllUsers() {
    List<UserAccount> users = userService.getAllUsers();
    return ResponseEntity.status(HttpStatus.OK).body(users);
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserAccount> getUserById(@PathVariable long id) {
    UserAccount user = userService.getUserById(id);
    return ResponseEntity.status(HttpStatus.OK).body(user);
  }

  @PutMapping("/{id}")
  public ResponseEntity<UserAccount> updateUser(
      @PathVariable long id,
      @RequestBody UserAccount user) {

    UserAccount updatedUser = userService.updateUser(id, user);
    return ResponseEntity.status(HttpStatus.OK).body(updatedUser);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteUser(@PathVariable long id) {
    userService.deleteUser(id);
    return ResponseEntity.noContent().build(); // 204 NO CONTENT
  }
}

