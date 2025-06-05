package com.alam.Airbnb.Strategy;

import com.alam.Airbnb.Entity.Inventory;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
public class SurgePricing implements PricingStrategy{

    private final PricingStrategy pricingStrategy;
    @Override
    public BigDecimal calculatePrice(Inventory inventory){
        BigDecimal price = pricingStrategy.calculatePrice(inventory);
        return price.multiply(inventory.getSurgeFactor());
    }
}
