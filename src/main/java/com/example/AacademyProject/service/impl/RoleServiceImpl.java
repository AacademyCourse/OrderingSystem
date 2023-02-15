package com.example.AacademyProject.service.impl;

import com.example.AacademyProject.entity.Role;
import com.example.AacademyProject.repository.RoleRepository;
import com.example.AacademyProject.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleNotFoundException;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getByAuthority(String roleName) throws RoleNotFoundException {
        return roleRepository.findByAuthority(roleName).orElseThrow(RoleNotFoundException::new);
    }
}
