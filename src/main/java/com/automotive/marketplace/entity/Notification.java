package com.automotive.marketplace.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "notifications")
public class Notification {

    
@Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "notificationId is required")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "notificationId is required")
    private String notificationId;
@NotBlank(message = "userId is required")
    @NotBlank(message = "userId is required")
    private String userId;
@NotBlank(message = "type is required")
    @NotBlank(message = "type is required")
    private String type;
@NotBlank(message = "title is required")
    @NotBlank(message = "title is required")
    private String title;
@NotBlank(message = "message is required")
    @NotBlank(message = "message is required")
    private String message;
@NotBlank(message = "referenceId is required")
    @NotBlank(message = "referenceId is required")
    private String referenceId;
private boolean isRead;
private java.time.LocalDateTime createdAt;

}