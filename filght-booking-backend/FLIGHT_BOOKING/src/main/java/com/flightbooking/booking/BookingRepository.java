package com.flightbooking.booking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    // Method to find bookings by userId
    List<Booking> findByUserId(Integer userId);

    // Method to find bookings by flightId
    List<Booking> findByFlightId(Integer flightId);
}
