package com.automotive.marketplace.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "payments")
public class Payment {


    
@Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "paymentId is required")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "paymentId is required")
    private String paymentId;
@NotBlank(message = "orderId is required")
    @NotBlank(message = "orderId is required")
    private String orderId;
private double amount;
@NotBlank(message = "paymentMode is required")
    @NotBlank(message = "paymentMode is required")
    private String paymentMode;
@NotBlank(message = "transactionRef is required")
    @NotBlank(message = "transactionRef is required")
    private String transactionRef;
@Enumerated(EnumType.STRING)
    @Enumerated(EnumType.STRING)
    private PaymentStatus status;
private java.time.LocalDateTime paidAt;


    public static enum PaymentStatus {

    INITIATED,
    SUCCESS,
    FAILED,
    REFUNDED
    }
}