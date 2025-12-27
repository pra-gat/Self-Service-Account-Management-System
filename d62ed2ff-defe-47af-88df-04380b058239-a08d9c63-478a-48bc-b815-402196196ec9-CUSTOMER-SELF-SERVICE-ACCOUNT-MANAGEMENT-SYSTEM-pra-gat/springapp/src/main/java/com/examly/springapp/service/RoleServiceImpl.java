// package com.examly.springapp.service;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.PageRequest;
// import org.springframework.data.domain.Pageable;
// import org.springframework.data.domain.Sort;
// import org.springframework.stereotype.Service;

// import com.examly.springapp.model.Role;
// import com.examly.springapp.repository.RoleRepo;
// @Service
// public class RoleServiceImpl implements RoleService{
//   @Autowired
//   RoleRepo roleRepo;

//   @Override
//   public Role AddRole(Role role) {
//     return roleRepo.save(role);
//   }

//   @Override
//   public Page<Role> paginationandSorting(int pageNo,int pageSize) {
//     Sort sort = Sort.by("roleId").ascending();
//     Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
//     return roleRepo.findAll(pageable);
//   }

//   @Override
//   public List<Role> GetAllRoles() {
//     return roleRepo.findAll();
//   }

//   @Override
//   public Role GetRoleById(long id) {
//     return roleRepo.findById(id).orElseThrow();
//   }

//   @Override
//   public Role UpdateRole(long id, Role role) {
//     if(!roleRepo.existsById(id)){
//       return null;
//     }
//     Role newRole = roleRepo.findById(id).orElse(null);
//     if(newRole!=null){
//       newRole.setRoleName(role.getRoleName());
//     }
//     return roleRepo.save(newRole);
//   }

//   @Override
//   public boolean DeleteRole(long id){
//     if(!roleRepo.existsById(id)){
//       return false;
//     }
//     roleRepo.deleteById(id);
//     return true;
//   }

// }
package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Role;
import com.examly.springapp.repository.RoleRepo;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepo roleRepo;

    @Override
    public Role AddRole(Role role) {
        return roleRepo.save(role);
    }

    @Override
    public List<Role> GetAllRoles() {
        return roleRepo.findAll();
    }

    @Override
    public Role GetRoleById(long id) {
        return roleRepo.findById(id).orElse(null); // ❗ no exception
    }

    @Override
    public Role UpdateRole(long id, Role role) {
        Role existing = roleRepo.findById(id).orElse(null);
        if (existing == null) {
            return null;
        }
        existing.setRoleName(role.getRoleName());
        return roleRepo.save(existing);
    }

    @Override
    public boolean DeleteRole(long id) {
        if (!roleRepo.existsById(id)) {
            return false;
        }
        roleRepo.deleteById(id);
        return true;
    }

    @Override
    public Page<Role> paginationandSorting(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by("roleId").ascending());
        return roleRepo.findAll(pageable);
    }
}



