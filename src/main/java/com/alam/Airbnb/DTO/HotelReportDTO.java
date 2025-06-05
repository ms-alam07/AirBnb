package com.alam.Airbnb.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelReportDTO {

    private Long bookingCount;
    private BigDecimal totalRevenue;
    private BigDecimal avgRevenue;
}
