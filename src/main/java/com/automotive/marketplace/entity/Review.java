package com.automotive.marketplace.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "reviews")
public class Review {

    
@Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "reviewId is required")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "reviewId is required")
    private String reviewId;
@NotBlank(message = "orderId is required")
    @NotBlank(message = "orderId is required")
    private String orderId;
@NotBlank(message = "reviewerId is required")
    @NotBlank(message = "reviewerId is required")
    private String reviewerId;
@NotBlank(message = "revieweeId is required")
    @NotBlank(message = "revieweeId is required")
    private String revieweeId;
private int rating;
private String comment;
private java.time.LocalDateTime createdAt;

}