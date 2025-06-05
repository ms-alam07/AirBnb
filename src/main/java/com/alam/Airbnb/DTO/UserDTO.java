package com.alam.Airbnb.DTO;

import com.alam.Airbnb.Enums.Gender;
import lombok.Data;

import java.time.LocalDate;
@Data
public class UserDTO {
    private Long id;
    private String email;
    private String name;
    private Gender gender;
    private LocalDate dateOfBirth;
}
