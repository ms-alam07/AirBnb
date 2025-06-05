package com.alam.Airbnb.Service.Interfaces;

import com.alam.Airbnb.DTO.HotelPriceDTO;
import com.alam.Airbnb.DTO.HotelSearchDTO;
import com.alam.Airbnb.DTO.InventoryDTO;
import com.alam.Airbnb.DTO.UpdateInventoryDTO;
import com.alam.Airbnb.Entity.Room;
import org.springframework.data.domain.Page;

import java.util.List;

public interface InventoryService {
    void initializeRoomForAYear(Room room);

    void deleteAllInventories(Room room);

    Page<HotelPriceDTO> searchHotels(HotelSearchDTO hotelSearchDTO);

    List<InventoryDTO> getAllInventoryByRoom(Long roomId);

    void updateInventory(Long roomId, UpdateInventoryDTO updateInventoryDTO);
}
