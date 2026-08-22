package com.automotive.marketplace.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "wishlists")
public class Wishlist {

    
@Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "wishlistId is required")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "wishlistId is required")
    private String wishlistId;
@NotBlank(message = "buyerId is required")
    @NotBlank(message = "buyerId is required")
    private String buyerId;
@NotBlank(message = "listingId is required")
    @NotBlank(message = "listingId is required")
    private String listingId;
private java.time.LocalDateTime addedAt;


}