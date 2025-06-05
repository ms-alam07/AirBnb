package com.alam.Airbnb.DTO;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
public class UpdateInventoryDTO {
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal surgeFactor;
    private Boolean closed;
}
