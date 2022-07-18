package com.Cab.Booking.Application.Entity;

import javax.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int age;
    private Long phone;
    private Integer locationId;
    private String vehicleNumber;
    private String vehicleName;
    private boolean active;
    private Double amount;
}
