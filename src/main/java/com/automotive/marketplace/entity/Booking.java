package com.automotive.marketplace.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "orderId is required")
    private String orderId;
    @NotBlank(message = "listingId is required")
    private String listingId;
    @NotBlank(message = "buyerId is required")
    private String buyerId;
    @NotBlank(message = "sellerId is required")
    private String sellerId;
    private double agreedPrice;
    private java.time.LocalDate bookingDate;
    @NotBlank(message = "deliveryMode is required")
    private String deliveryMode;
    private InspectionReportState status;

}