package com.flightbooking.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import com.flightbooking.flight.*;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private FlightService flightService;  // To access flight details

    public Booking createBooking(Booking booking) throws Exception {
        // Check if the flight has enough available seats
        Flight flight = flightService.getFlightById(booking.getFlightId())
                .orElseThrow(() -> new Exception("Flight not found"));

        if (flight.getAvailableSeats() < booking.getSeatCount()) {
            throw new Exception("Not enough seats available");
        }

        // Update the available seats for the flight
        flight.setAvailableSeats(flight.getAvailableSeats() - booking.getSeatCount());
        flightService.updateFlight(flight);

        // Create booking
        booking.setTotalPrice(booking.getSeatCount() * flight.getPrice());  // Calculate total price
        booking.setStatus("CONFIRMED");

        return bookingRepository.save(booking);
    }

    public Booking cancelBooking(Integer bookingId) throws Exception {
        // Retrieve the booking and cancel it
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new Exception("Booking not found"));

        // Check if the booking is already canceled
        if ("CANCELLED".equals(booking.getStatus())) {
            throw new Exception("Booking already cancelled");
        }

        // Update the available seats for the flight
        Flight flight = flightService.getFlightById(booking.getFlightId())
                .orElseThrow(() -> new Exception("Flight not found"));
        flight.setAvailableSeats(flight.getAvailableSeats() + booking.getSeatCount());
        flightService.updateFlight(flight);

        // Change the booking status
        booking.setStatus("CANCELLED");
        return bookingRepository.save(booking);
    }

    public List<Booking> getBookingsByUserId(Integer userId) {
        return bookingRepository.findByUserId(userId);
    }

    public List<Booking> getBookingsByFlightId(Integer flightId) {
        return bookingRepository.findByFlightId(flightId);
    }
}
