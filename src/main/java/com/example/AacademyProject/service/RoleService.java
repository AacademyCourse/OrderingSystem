package com.example.AacademyProject.service;

import com.example.AacademyProject.entity.Role;

import javax.management.relation.RoleNotFoundException;

public interface RoleService {
    Role getByAuthority(String roleName) throws RoleNotFoundException;
}
