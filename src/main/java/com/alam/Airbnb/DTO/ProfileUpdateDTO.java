package com.alam.Airbnb.DTO;

import com.alam.Airbnb.Enums.Gender;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ProfileUpdateDTO {
    private String name;
    private LocalDate dateOfBirth;
    private Gender gender;
}
