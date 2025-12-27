package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Profile;
import com.examly.springapp.repository.ProfileRepo;

@Service
public class ProfileServiceImpl implements ProfileService{
  @Autowired
  private ProfileRepo profileRepo;

  @Override
  public Profile postProfile(Profile profile){
    return profileRepo.save(profile);
  }

  @Override
  public List<Profile> getAllProfile() {
    return profileRepo.findAll();
  }

  @Override
  public Profile getProfileById(long id) {
    return profileRepo.findById(id).orElse(null);
  }

  @Override
  public Profile updateProfile(long id, Profile profile) {

    Profile existingProfile = profileRepo.findById(id).orElse(null);

    if (existingProfile == null) {
      return null;
    }

    existingProfile.setFirstName(profile.getFirstName());
    existingProfile.setLastName(profile.getLastName());
    existingProfile.setAddress(profile.getAddress());
    existingProfile.setDob(profile.getDob());
    existingProfile.setGender(profile.getGender());

    return profileRepo.save(existingProfile);
  }

  @Override
  public List<Profile> getByName(String name) {
    return profileRepo.findByFirstName(name);
  }
  
  @Override
  public List<Profile> getByNameAndAddress(String name, String address) {
    return profileRepo.findByFirstNameAndAddress(name, address);
  }
  @Override
  public void deleteProfile(long id) {
    profileRepo.deleteById(id);
  }
}

