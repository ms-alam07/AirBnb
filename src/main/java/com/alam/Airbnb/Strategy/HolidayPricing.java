package com.alam.Airbnb.Strategy;

import com.alam.Airbnb.Entity.Inventory;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
public class HolidayPricing implements PricingStrategy{

    private final PricingStrategy pricingStrategy;
    @Override
    public BigDecimal calculatePrice(Inventory inventory){
        BigDecimal price = pricingStrategy.calculatePrice(inventory);
        boolean holidayToday = true; // call an API or check with local data
        if(holidayToday){
            price = price.multiply(BigDecimal.valueOf(1.25));
        }
        return price;
    }
}
