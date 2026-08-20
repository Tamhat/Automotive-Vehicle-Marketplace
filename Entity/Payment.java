package Entity;

public class Payment {
    
private String paymentId;
private String orderId;
private double amount;
private String paymentMode;
private String transactionRef;
private PaymentStatus status; // Initiated/Success/Failed/Refunded
private java.time.LocalDateTime paidAt;

}

enum PaymentStatus {
    INITIATED,
    SUCCESS,
    FAILED,
    REFUNDED
}