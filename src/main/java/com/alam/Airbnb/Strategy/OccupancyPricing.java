package com.alam.Airbnb.Strategy;

import com.alam.Airbnb.Entity.Inventory;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
public class OccupancyPricing implements  PricingStrategy{

    private final PricingStrategy pricingStrategy;
    @Override
    public BigDecimal calculatePrice(Inventory inventory){
        BigDecimal price = pricingStrategy.calculatePrice(inventory);
        double occupancyRate = (double) inventory.getBookCount()/inventory.getTotalCount();
        if(occupancyRate > 0.8){
            price = price.multiply(BigDecimal.valueOf(1.20));
        }
        return price;
    }
}
