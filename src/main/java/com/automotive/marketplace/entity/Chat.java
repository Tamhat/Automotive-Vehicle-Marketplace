package com.automotive.marketplace.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "chats")
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "messageId is required")
    private String messageId;
    @NotBlank(message = "threadId is required")
    private String threadId;
    @NotBlank(message = "listingId is required")
    private String listingId;
    @NotBlank(message = "senderId is required")
    private String senderId;
    @NotBlank(message = "receiverId is required")
    private String receiverId;
    @NotBlank(message = "content is required")
    private String content;
    private java.time.LocalDateTime sentAt;
    private boolean isRead;

}