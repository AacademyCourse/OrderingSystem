package com.example.AacademyProject.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

//    @Min(3)
//    @Max(50)
    @Column(name = "customer_name",length = 50)
    private String customerName;

//    @Min(3)
//    @Max(100)
    @Column(name = "customer_last_name",length = 100)
    private String customerLastName;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "email_id")
    private Email customerEmail;

    private String password;

    private Instant createdAt;

    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    private Set<Order> orders = new HashSet<>();


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "customer_roles",
            joinColumns = {@JoinColumn(name = "customer_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private Set<Role> roles;


}
