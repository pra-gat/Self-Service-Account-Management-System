package com.examly.springapp.controller;

import java.util.List;

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

import com.examly.springapp.model.Profile;
import com.examly.springapp.service.ProfileService;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {
  @Autowired
  private ProfileService profileService;

  @PostMapping()
  public ResponseEntity<Profile> addProfile(@RequestBody Profile profile){
      Profile newProfile = profileService.postProfile(profile);
      if(newProfile!=null){
        return ResponseEntity.status(HttpStatus.CREATED).body(newProfile);
      }
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
  }
  @GetMapping()
  public ResponseEntity<List<Profile>> getAllProfile(){
    List<Profile> newProfile = profileService.getAllProfile();
    if(newProfile!=null){
      return ResponseEntity.status(HttpStatus.OK).body(newProfile);
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
  }
  @GetMapping("/{id}")
  public ResponseEntity<Profile> getProfileById(@PathVariable long id){
    Profile newProfile = profileService.getProfileById(id);
    if(newProfile!=null){
      return ResponseEntity.status(HttpStatus.OK).body(newProfile);
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
  }
   @PutMapping("/{id}")
  public ResponseEntity<Profile> updateProfile(@RequestBody Profile profile,@PathVariable long id){
    Profile updatedProfile = profileService.updateProfile(id, profile);

    if (updatedProfile != null) {
      return ResponseEntity.status(HttpStatus.OK).body(updatedProfile);
    }

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteProfile(@PathVariable long id) {
    profileService.deleteProfile(id);
    return ResponseEntity.noContent().build(); 
  }

  @GetMapping("/name/{name}")
  public ResponseEntity<List<Profile>> getByName(
      @PathVariable String name) {

        List<Profile> profile = profileService.getByName(name);
        if(profile!=null){
          return ResponseEntity.status(HttpStatus.OK).body(profile);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
  }

  @GetMapping("/search/{name}/{address}")
  public ResponseEntity<List<Profile>> getByNameAndAddress(
      @PathVariable String name,
      @PathVariable String address) {

    List<Profile> profiles =
    profileService.getByNameAndAddress(name, address);

    if (profiles.isEmpty()) {
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.ok(profiles);
  }
}


