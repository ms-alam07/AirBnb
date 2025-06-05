package com.alam.Airbnb.Service.Interfaces;

import com.alam.Airbnb.Entity.Booking;

public interface CheckoutService {
    String getCheckoutSession(Booking booking, String successUrl, String failureUrl);
}
