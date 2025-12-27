package com.examly.springapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examly.springapp.model.Profile;

@Service
public interface ProfileService {
  Profile postProfile(Profile profile);
  List<Profile> getAllProfile();
  Profile getProfileById(long id);
  Profile updateProfile(long id, Profile profile);

  public List<Profile> getByName(String name);

  public List<Profile> getByNameAndAddress(String name, String address);

  void deleteProfile(long id);
  
}
