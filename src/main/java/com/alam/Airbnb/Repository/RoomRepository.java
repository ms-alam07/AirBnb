package com.alam.Airbnb.Repository;

import com.alam.Airbnb.Entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}