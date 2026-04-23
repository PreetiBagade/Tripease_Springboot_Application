package com.example.tripease.model;

import com.example.tripease.enums.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor //default construtor
@AllArgsConstructor //parameterised construtor
@Getter // all getters of attributes
@Setter //all setters of attributes
@Builder
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    private String name;
    private int age;
    @Column(unique = true, nullable = false)
    private String emailId;
    @Enumerated(value = EnumType.STRING)
    private Gender gender;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    List<Booking> bookings = new ArrayList<>();
}
