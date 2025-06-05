package com.alam.Airbnb.DTO;

import com.alam.Airbnb.Enums.Gender;
import lombok.Data;

@Data
public class GuestDTO {

    private Long id;
    private String name;
    private Gender gender;
    private Integer age;
}
