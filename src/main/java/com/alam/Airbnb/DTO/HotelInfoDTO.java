package com.alam.Airbnb.DTO;

import com.alam.Airbnb.Entity.Room;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class HotelInfoDTO {
    private HotelDTO hotel;
    private List<RoomDTO> rooms;

    public <D> HotelInfoDTO(D map, List<Room> rooms) {
    }
}
