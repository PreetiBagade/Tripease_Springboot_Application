package com.example.tripease.dto.request;
import com.example.tripease.enums.Gender;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class CustomerRequest {

    private String name;
    private int age;
    private String emailId;
    private Gender gender;
}
