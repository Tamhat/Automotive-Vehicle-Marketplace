package com.automotive.marketplace.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "offers")
public class Offer {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "offerId is required")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "offerId is required")
    private String offerId;
    @NotBlank(message = "listingId is required")
    @NotBlank(message = "listingId is required")
    private String listingId;
    @NotBlank(message = "buyerId is required")
    @NotBlank(message = "buyerId is required")
    private String buyerId;
    private double offerAmount;
    private double counterAmount;
    @NotBlank(message = "message is required")
    @NotBlank(message = "message is required")
    private String message;
    @Enumerated(EnumType.STRING)
    @Enumerated(EnumType.STRING)
    private OfferStatus status; 
    private java.time.LocalDateTime createdAt;
    private java.time.LocalDateTime expiresAt;


    public static enum OfferStatus {

    PENDING,
    COUNTERED,
    ACCEPTED,
    REJECTED,
    EXPIRED,
    WITHDRAWN
    }
}