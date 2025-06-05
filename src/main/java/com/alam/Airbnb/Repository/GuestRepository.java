package com.alam.Airbnb.Repository;

import com.alam.Airbnb.DTO.GuestDTO;
import com.alam.Airbnb.Entity.Guest;
import com.alam.Airbnb.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuestRepository extends JpaRepository<Guest, Long> {
    List<GuestDTO> findByUser(User user);
}