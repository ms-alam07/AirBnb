package com.alam.Airbnb.DTO;

import com.alam.Airbnb.Enums.BookingStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingStatusDTO {

    private BookingStatus bookingStatus;

}
