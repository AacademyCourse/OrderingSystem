package com.example.AacademyProject.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    @Column(name = "customer_name",length = 50)
    private String customerName;

    @Column(name = "customer_last_name",length = 100)
    private String customerLastName;

    @OneToOne
    @JoinColumn(name = "email_id")
    private Email customerEmail;

    @OneToMany(mappedBy = "customer",fetch = FetchType.EAGER)
    private Set<Order> orders = new HashSet<>();

}
