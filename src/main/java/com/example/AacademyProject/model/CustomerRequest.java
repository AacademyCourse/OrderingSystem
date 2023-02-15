package com.example.AacademyProject.model;

import com.example.AacademyProject.entity.Customer;
import com.example.AacademyProject.entity.Email;
import com.example.AacademyProject.entity.Role;
import com.example.AacademyProject.service.impl.RoleServiceImpl;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.management.relation.RoleNotFoundException;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
@Component
@Getter
@NoArgsConstructor
public class CustomerRequest implements Serializable {


    private static RoleServiceImpl roleService;
    @Autowired
    public CustomerRequest(RoleServiceImpl roleService){
        CustomerRequest.roleService = roleService;
    }

    @NotNull(message = "Name couldn't be null")
    @Size(min = 3, max =50, message = "Name should be between 3 and 50 characters")
    private String name;
    private String lastName;
    @jakarta.validation.constraints.Email
    private String email;
    private String password;
    @JsonProperty("user_roles")
    private ArrayList<String> userRoles = new ArrayList<>();


    public Customer convert() {
        return Customer.builder()
                .customerName(this.getName())
                .customerLastName(this.getLastName())
                .customerEmail(new Email(this.getEmail()))
                .createdAt(Instant.now())
                .roles(setRoles(userRoles))
                .password(this.getPassword())
                .build();
    }

    private Set<Role> setRoles(ArrayList<String> userRoles){
        Set<Role> checkedRoles = new HashSet<>();

        for (int i = 0; i < userRoles.size() ; i++) {
            try {
                checkedRoles.add(roleService.getByAuthority(userRoles.get(i)));
            } catch (RoleNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return checkedRoles;
    }


}
