package com.flightbooking.booking;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer userId;

    @Column(nullable = false)
    private Integer flightId;

    @Column(nullable = false)
    private String passengerName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private Integer seatCount;

    @Column(nullable = false)
    private Double totalPrice;

    

    @Column(nullable = false)
    private String status;  // "CONFIRMED" or "CANCELLED"

    public Booking() {}

    public Booking(Integer userId, Integer flightId, String passengerName, String email, Integer seatCount, 
                   Double totalPrice, String status) {
        this.userId = userId;
        this.flightId = flightId;
        this.passengerName = passengerName;
        this.email = email;
        this.seatCount = seatCount;
        this.totalPrice = totalPrice;
        
        this.status = status;
    }

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }

    public Integer getFlightId() { return flightId; }
    public void setFlightId(Integer flightId) { this.flightId = flightId; }

    public String getPassengerName() { return passengerName; }
    public void setPassengerName(String passengerName) { this.passengerName = passengerName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Integer getSeatCount() { return seatCount; }
    public void setSeatCount(Integer seatCount) { this.seatCount = seatCount; }

    public Double getTotalPrice() { return totalPrice; }
    public void setTotalPrice(Double totalPrice) { this.totalPrice = totalPrice; }

    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}