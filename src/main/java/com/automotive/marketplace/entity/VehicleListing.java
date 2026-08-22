package com.automotive.marketplace.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "vehicle_listings")
public class VehicleListing {


    
@Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "listingId is required")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "listingId is required")
    private String listingId;
@NotBlank(message = "sellerId is required")
    @NotBlank(message = "sellerId is required")
    private String sellerId;
@NotBlank(message = "vehicleId is required")
    @NotBlank(message = "vehicleId is required")
    private String vehicleId;
private double price;
private String description;
private String[] images;
@NotBlank(message = "location is required")
    @NotBlank(message = "location is required")
    private String location;
@Enumerated(EnumType.STRING)
    @Enumerated(EnumType.STRING)
    private ListingStatus status;
private boolean isFeatured;
private int viewCount;
private java.time.LocalDateTime postedAt;
private java.time.LocalDateTime expiresAt;



    public static enum ListingStatus {

    DRAFT,
    PENDING_APPROVAL,
    ACTIVE,
    RESERVED,
    SOLD,
    EXPIRED,
    REMOVED
    }
}