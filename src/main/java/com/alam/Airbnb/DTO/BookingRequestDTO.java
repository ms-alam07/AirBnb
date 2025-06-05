package com.alam.Airbnb.DTO;

import lombok.Data;

import java.time.LocalDate;
@Data
public class BookingRequestDTO {
    private Long hotelId;
    private Long roomId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Integer roomsCount;
}
