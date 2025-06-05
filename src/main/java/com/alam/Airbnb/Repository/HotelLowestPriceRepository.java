package com.alam.Airbnb.Repository;

import com.alam.Airbnb.DTO.HotelPriceDTO;
import com.alam.Airbnb.Entity.Hotel;
import com.alam.Airbnb.Entity.HotelLowestPrice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Optional;

public interface HotelLowestPriceRepository extends JpaRepository<HotelLowestPrice, Long> {

  @Query("""
            SELECT new com.alam.AirBnb.Dto.HotelPriceDTO(i.hotel, AVG(i.price))
            FROM HotelLowestPrice i
            WHERE i.hotel.city = :city
                AND i.date BETWEEN :startDate AND :endDate
                AND i.hotel.active = true
           GROUP BY i.hotel
           """)
  Page<HotelPriceDTO> findHotelsWithAvailableInventory(
          @Param("city") String city,
          @Param("startDate") LocalDate startDate,
          @Param("endDate") LocalDate endDate,
          @Param("roomsCount") Integer roomsCount,
          @Param("dateCount") Long dateCount,
          Pageable pageable
  );

  Optional<HotelLowestPrice> findByHotelAndDate(Hotel hotel, LocalDate date);
}