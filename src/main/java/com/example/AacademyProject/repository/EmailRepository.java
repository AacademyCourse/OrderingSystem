package com.example.AacademyProject.repository;

import com.example.AacademyProject.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<Email,Long> {
    @Query(value = "select em from Email em where em.emailAddress = ?1")
    Email existsByemailAddress(String emailAddress);
}
