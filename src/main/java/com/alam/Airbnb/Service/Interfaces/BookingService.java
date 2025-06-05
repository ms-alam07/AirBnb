package com.alam.Airbnb.Service.Interfaces;

import com.alam.Airbnb.DTO.BookingDTO;
import com.alam.Airbnb.DTO.BookingRequestDTO;
import com.alam.Airbnb.DTO.GuestDTO;
import com.alam.Airbnb.DTO.HotelReportDTO;
import com.alam.Airbnb.Enums.BookingStatus;

import java.time.LocalDate;
import java.util.List;

public interface BookingService {
    List<BookingDTO> getMyBookings();

    BookingDTO initialiseBooking(BookingRequestDTO bookingRequestDTO);

    BookingDTO addGuests(Long bookingId, List<GuestDTO> guestDtoList);

    String initiatePayments(Long bookingId);

    //    Stripe Method Name called Event for Payment
    //    void capturePayment(Event event);

    void cancelBooking(Long bookingId);

    BookingStatus getBookingStatus(Long bookingId);

    List<BookingDTO> getAllBookingsByHotelId(Long hotelId);

    HotelReportDTO getHotelReport(Long hotelId, LocalDate startDate, LocalDate endDate);
}
