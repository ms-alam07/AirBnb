package com.alam.Airbnb.Strategy;

import com.alam.Airbnb.Entity.Inventory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PricingService {

    public BigDecimal calculateDynamicPricing(Inventory inventory){
        PricingStrategy pricingStrategy = new BasePricing();

        //Applying other Strategies
        pricingStrategy = new HolidayPricing(pricingStrategy);
        pricingStrategy = new OccupancyPricing(pricingStrategy);
        pricingStrategy = new SurgePricing(pricingStrategy);
        pricingStrategy  = new UrgencyPricing(pricingStrategy);

        return pricingStrategy.calculatePrice(inventory);
    }

    public BigDecimal calculateTotalPrice(List<Inventory> inventoryList) {
        return inventoryList.stream()
                .map(this::calculateDynamicPricing)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
