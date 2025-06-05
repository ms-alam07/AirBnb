package com.alam.Airbnb.Strategy;

import com.alam.Airbnb.Entity.Inventory;

import java.math.BigDecimal;

public interface PricingStrategy {
    BigDecimal calculatePrice(Inventory inventory);
}
