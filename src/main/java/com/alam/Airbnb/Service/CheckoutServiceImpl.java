package com.alam.Airbnb.Service;

import com.alam.Airbnb.Entity.Booking;
import com.alam.Airbnb.Entity.User;
import com.alam.Airbnb.Repository.BookingRepository;
import com.alam.Airbnb.Service.Interfaces.CheckoutService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
@Slf4j
// implements CheckoutService  ===== Not writing with class bcz we need to implement those inherited methods from interface
public class CheckoutServiceImpl {
    private final BookingRepository bookingRepository;

//    @Override
//    public String getCheckoutSession(Booking booking, String successUrl, String failureUrl) {
//        log.info("Creating session for booking with ID: {}", booking.getId());
//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//        try {
//            CustomerCreateParams customerParams = CustomerCreateParams.builder()
//                    .setName(user.getName())
//                    .setEmail(user.getEmail())
//                    .build();
//            Customer customer = Customer.create(customerParams);
//
//            SessionCreateParams sessionParams = SessionCreateParams.builder()
//                    .setMode(SessionCreateParams.Mode.PAYMENT)
//                    .setBillingAddressCollection(SessionCreateParams.BillingAddressCollection.REQUIRED)
//                    .setCustomer(customer.getId())
//                    .setSuccessUrl(successUrl)
//                    .setCancelUrl(failureUrl)
//                    .addLineItem(
//                            SessionCreateParams.LineItem.builder()
//                                    .setQuantity(1L)
//                                    .setPriceData(
//                                            SessionCreateParams.LineItem.PriceData.builder()
//                                                    .setCurrency("inr")
//                                                    .setUnitAmount(booking.getAmount().multiply(BigDecimal.valueOf(100)).longValue())
//                                                    .setProductData(
//                                                            SessionCreateParams.LineItem.PriceData.ProductData.builder()
//                                                                    .setName(booking.getHotel().getName() +" : "+ booking.getRoom().getType())
//                                                                    .setDescription("Booking ID: "+booking.getId())
//                                                                    .build()
//                                                    )
//                                                    .build()
//                                    )
//                                    .build()
//                    )
//                    .build();
//
//            Session session = Session.create(sessionParams);
//
//            booking.setPaymentSessionId(session.getId());
//            bookingRepository.save(booking);
//
//            log.info("Session created successfully for booking with ID: {}", booking.getId());
//            return session.getUrl();
//
//        } catch (StripeException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
}
