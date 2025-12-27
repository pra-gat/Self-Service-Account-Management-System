package com.examly.springapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Role {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonProperty("id")
  private long roleId;
  @Column(name = "role_name")
  private String roleName;
  public long getRoleId() {
    return roleId;
  }
  public void setRoleId(long roleId) {
    this.roleId = roleId;
  }
  public String getRoleName() {
    return roleName;
  }
  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }
  public Role() {
  }
  public Role(String roleName) {
    this.roleName = roleName;
  }
  
  
}

