package com.examly.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class UserRoleMapping {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @ManyToOne
  @JoinColumn(name = "user_id")
  private UserAccount user;
  @ManyToOne
  @JoinColumn(name = "role_id")
  private Role role;
  public long getId() {
    return id;
  }
  public void setId(long id) {
    this.id = id;
  }
  public UserAccount getUser() {
    return user;
  }
  public void setUser(UserAccount user) {
    this.user = user;
  }
  public Role getRole() {
    return role;
  }
  public void setRole(Role role) {
    this.role = role;
  }
  
  public UserRoleMapping() {
  }
  public UserRoleMapping(UserAccount user, Role role) {
    this.user = user;
    this.role = role;
  }
  
}

