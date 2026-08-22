package com.automotive.marketplace.entity;

public class User {
    
private String userId;
private String name;
private String email;
private String phone;
private String passwordHash;
private UserRole role; 
private String profilePicture;
private String address;
private String city;
private boolean isVerified;
private String kycStatus;
private double rating; // average rating
// private String dealershipId; // nullable, dealer hole
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