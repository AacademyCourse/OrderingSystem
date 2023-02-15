package com.example.AacademyProject.controller;

import com.example.AacademyProject.entity.Email;
import com.example.AacademyProject.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/email")
public class EmailController {
    @Autowired
    EmailRepository emailRepository;

     @PostMapping(path = "/ifExists")
     public Email getEmail(@RequestBody String email){
        return emailRepository.existsByemailAddress(email);
    }
}
