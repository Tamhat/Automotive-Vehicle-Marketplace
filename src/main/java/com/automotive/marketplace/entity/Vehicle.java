package com.automotive.marketplace.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "vehicles")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "vehicleId is required")
    private String vehicleId;
    @NotBlank(message = "VIN is required")
    private String VIN;
    @NotBlank(message = "model is required")
    private String model;
    @NotBlank(message = "manufacturer is required")
    private String manufacturer;
    private int year;
    private int mileage;
    private double price;
    @NotBlank(message = "condition is required")
    private String condition;
    @NotBlank(message = "location is required")
    private String location;
    @NotBlank(message = "ownership is required")
    private String ownership;
}