package com.examly.springapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.UserRoleMapping;

@Repository
public interface UserRoleMappingRepo extends JpaRepository<UserRoleMapping,Long>{
  List<UserRoleMapping> findByUser_Id(Long userId);
  UserRoleMapping findByUser_IdAndRole_RoleId(Long userId, Long roleId);
  
  @Query("""
    SELECT urm
    FROM UserRoleMapping urm
    WHERE urm.user.id = :userId
  """)
  List<UserRoleMapping> findByUserId(@Param("userId") Long userId);

  // Day12_testGetUserRoleMappingByUserIdAndRoleId
  @Query("""
    SELECT urm
    FROM UserRoleMapping urm
    WHERE urm.user.id = :userId
     AND urm.role.roleId = :roleId
  """)
  List<UserRoleMapping> findByUserIdAndRoleId(
      @Param("userId") Long userId,
      @Param("roleId") Long roleId
  );
}

