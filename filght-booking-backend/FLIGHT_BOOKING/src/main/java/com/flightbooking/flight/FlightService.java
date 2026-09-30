package com.flightbooking.flight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Optional<Flight> getFlightById(Integer id) {
        return flightRepository.findById(id);
    }

    public Flight addFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public void deleteFlight(Integer id) {
        flightRepository.deleteById(id);
    }

    public Flight bookTicket(Integer flightId) throws Exception {
        Flight flight = flightRepository.findById(flightId)
                .orElseThrow(() -> new Exception("Flight not found!"));

        if (flight.getAvailableSeats() > 0) {
            flight.setAvailableSeats(flight.getAvailableSeats() - 1);
            return flightRepository.save(flight);
        } else {
            throw new Exception("No seats available!");
        }
    }

    public Flight cancelTicket(Integer flightId) throws Exception {
        Flight flight = flightRepository.findById(flightId)
                .orElseThrow(() -> new Exception("Flight not found!"));

        if (flight.getAvailableSeats() < flight.getTotalSeats()) {
            flight.setAvailableSeats(flight.getAvailableSeats() + 1);
            return flightRepository.save(flight);
        } else {
            throw new Exception("All seats are already available!");
        }
    }
    public Flight updateFlight(Flight flight) {
        return flightRepository.save(flight); // Saves the updated flight to the database
    }
}
