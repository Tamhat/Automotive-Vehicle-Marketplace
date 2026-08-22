package com.automotive.marketplace.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {

    
@Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "userId is required")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "userId is required")
    private String userId;
@NotBlank(message = "name is required")
    @NotBlank(message = "name is required")
    private String name;
@Email(message = "Invalid email format")
    @NotBlank(message = "email is required")
    @Email(message = "Invalid email format")
    @NotBlank(message = "email is required")
    private String email;
@Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Invalid phone number format")
    @NotBlank(message = "phone is required")
    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Invalid phone number format")
    @NotBlank(message = "phone is required")
    private String phone;
private String passwordHash;
@Enumerated(EnumType.STRING)
    @Enumerated(EnumType.STRING)
    private UserRole role; 
private String profilePicture;
private String address;
@NotBlank(message = "city is required")
    @NotBlank(message = "city is required")
    private String city;
private boolean isVerified;
@NotBlank(message = "kycStatus is required")
    @NotBlank(message = "kycStatus is required")
    private String kycStatus;
private double rating;
// @NotBlank(message = "dealershipId is required")
    @NotBlank(message = "dealershipId is required")
    private String dealershipId;
private java.time.LocalDateTime createdAt;

    public static enum UserRole {

    BUYER,
    SELLER,
    DEALER,
    ADMIN,
    INSPECTOR,
    DELIVERY_AGENT
    }
}