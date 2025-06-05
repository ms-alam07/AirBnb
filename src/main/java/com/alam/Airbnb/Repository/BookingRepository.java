package com.alam.Airbnb.Repository;

import com.alam.Airbnb.Entity.Booking;
import com.alam.Airbnb.Entity.Hotel;
import com.alam.Airbnb.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long> {

  Optional<Booking> findByPaymentSessionId(String sessionId);
  List<Booking> findByHotel(Hotel hotel);
  List<Booking> findByHotelAndCreatedAtBetween(Hotel hotel, LocalDateTime startDateTime, LocalDateTime endDateTime);
  List<Booking> findByUser(User user);
}