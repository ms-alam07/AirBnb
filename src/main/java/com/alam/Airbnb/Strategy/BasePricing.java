package com.alam.Airbnb.Strategy;

import com.alam.Airbnb.Entity.Inventory;

import java.math.BigDecimal;

public class BasePricing implements PricingStrategy{
    @Override
    public BigDecimal calculatePrice(Inventory inventory){
        return inventory.getRoom().getBasePrice();
    }
}
