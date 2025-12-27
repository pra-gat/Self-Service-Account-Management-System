package com.examly.springapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.examly.springapp.model.UserRoleMapping;
import com.examly.springapp.service.UserRoleMappingService;

@RestController
@RequestMapping("/api/userRoleMappings")
public class UserRoleMappingController {
  @Autowired
  private UserRoleMappingService userRoleMappingService;

  @PostMapping
  public ResponseEntity<UserRoleMapping> postUserRoleMapping(@RequestBody UserRoleMapping userRoleMapping){
    UserRoleMapping newUserRoleMapping = userRoleMappingService.addUserRoleMapping(userRoleMapping);
    if(newUserRoleMapping != null){
      return ResponseEntity.status(HttpStatus.CREATED).body(newUserRoleMapping);
    }
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
  }

  @GetMapping
  public ResponseEntity<List<UserRoleMapping>> getAllUserRoleMappings(){
    List<UserRoleMapping> mappings = userRoleMappingService.getAllUserRoleMappings();
    if(mappings != null && !mappings.isEmpty()){
      return ResponseEntity.status(HttpStatus.OK).body(mappings);
    }
    return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
  }
    @GetMapping("/{id}")
  public ResponseEntity<UserRoleMapping> getUserRoleMappingById(@PathVariable Long id){
    UserRoleMapping mapping = userRoleMappingService.getUserRoleMappingById(id);
    if(mapping != null){
      return ResponseEntity.status(HttpStatus.OK).body(mapping);
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
  }

  @PutMapping("/{id}")
  public ResponseEntity<UserRoleMapping> updateUserRoleMapping(@PathVariable Long id,
                                 @RequestBody UserRoleMapping userRoleMapping){
    UserRoleMapping updated = userRoleMappingService.updateUserRoleMapping(id, userRoleMapping);
    if(updated != null){
      return ResponseEntity.status(HttpStatus.OK).body(updated);
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
  }
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteUserRoleMapping(@PathVariable long id) {
    userRoleMappingService.deleteUserRoleMapping(id);
    return ResponseEntity.noContent().build(); 
  }
  @GetMapping("/user/{userId}")
  public ResponseEntity<List<UserRoleMapping>> getByUserId(
      @PathVariable Long userId) {

    List<UserRoleMapping> mappings = userRoleMappingService.getUserRoleMappingsByUserId(userId);

    if (mappings.isEmpty()) {
      return ResponseEntity.noContent().build(); 
    }
    return ResponseEntity.ok(mappings);
  }

  @GetMapping("/user/{userId}/role/{roleId}")
  public ResponseEntity<Optional<UserRoleMapping>> getByUserIdAndRoleId(
      @PathVariable Long userId,
      @PathVariable Long roleId) {

        Optional<UserRoleMapping> newUserRoleMapping = userRoleMappingService.getUserRoleMappingByUserIdAndRoleId(userId, roleId);
        if(newUserRoleMapping!=null){
          return ResponseEntity.status(HttpStatus.OK).body(newUserRoleMapping);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
  }
}



