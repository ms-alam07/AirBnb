package com.alam.Airbnb.Controller;

import com.alam.Airbnb.DTO.HotelInfoDTO;
import com.alam.Airbnb.DTO.HotelPriceDTO;
import com.alam.Airbnb.DTO.HotelSearchDTO;
import com.alam.Airbnb.Service.Interfaces.HotelService;
import com.alam.Airbnb.Service.Interfaces.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotel")
@RequiredArgsConstructor
public class HotelBrowseController {

    private final InventoryService inventoryService;
    private final HotelService hotelService;

    @GetMapping("/search")
    public ResponseEntity<Page<HotelPriceDTO>> searchHotels(@RequestBody HotelSearchDTO hotelSearchDTO) {
        Page<HotelPriceDTO> page = inventoryService.searchHotels(hotelSearchDTO);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{hotelId}/info")
    public ResponseEntity<HotelInfoDTO> getHotelInfo(@PathVariable Long hotelId) {
        return ResponseEntity.ok(hotelService.getHotelInfoById(hotelId));
    }
}
