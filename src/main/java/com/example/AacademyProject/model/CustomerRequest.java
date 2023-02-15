package com.example.AacademyProject.model;

import com.example.AacademyProject.entity.Customer;
import com.example.AacademyProject.entity.Email;
import com.example.AacademyProject.entity.Role;
import lombok.Getter;

import java.time.Instant;
import java.util.Set;
@Getter
public class CustomerRequest {
   private String name;
   private String lastName;
   private String email;
   private String password;


  public Customer convert(){
      return Customer.builder()
              .customerName(this.getName())
              .customerLastName(this.getLastName())
              .customerEmail(new Email(this.getEmail()))
              .createdAt(Instant.now())
              .password(this.getPassword())
              .build();
   }
}
