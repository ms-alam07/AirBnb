package com.alam.Airbnb.Service.Interfaces;

import com.alam.Airbnb.DTO.GuestDTO;

import java.util.List;

public interface GuestService {
    GuestDTO addNewGuest(GuestDTO guestDto);

    void updateGuest(Long guestId, GuestDTO guestDto);

    List<GuestDTO> getAllGuests();

    void deleteGuest(Long guestId);
}
