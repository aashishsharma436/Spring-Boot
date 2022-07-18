package com.Cab.Booking.Application.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Ride {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int sourceId;
    private int destinationId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUser appUser;
    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;
    private Double billing;
}
