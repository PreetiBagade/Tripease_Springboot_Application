package com.example.tripease.model;

import com.example.tripease.enums.TripStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;
    private String pickup;
    private String destination;
    private double tripDistanceInKm;
    @Enumerated(EnumType.STRING)
    private TripStatus tripStatus;
    private double billAmount;

    @CreationTimestamp
    private LocalDateTime bookedDt;

    @UpdateTimestamp
    private LocalDateTime lastUpdatedAt;

}
