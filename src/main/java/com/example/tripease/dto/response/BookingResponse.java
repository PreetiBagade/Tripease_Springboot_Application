package com.example.tripease.dto.response;

import com.example.tripease.enums.TripStatus;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BookingResponse {

    private String pickup;
    private String destination;
    private double tripDistanceInKm;
    private TripStatus tripStatus;
    private double billAmount;
    private LocalDateTime bookedDt;
    private LocalDateTime lastUpdatedAt;
    CustomerResponse customer;
    CabResponse cab;
}
