package com.alam.Airbnb.Repository;

import com.alam.Airbnb.Entity.Hotel;
import com.alam.Airbnb.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
  List<Hotel> findByOwner(User user);
}