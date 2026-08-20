package Entity;

public class Offer {
    private String offerId;
    private String listingId;
    private String buyerId;
    private double offerAmount;
    private double counterAmount;
    private String message;
    private OfferStatus status; 
    private java.time.LocalDateTime createdAt;
    private java.time.LocalDateTime expiresAt;

}

enum OfferStatus {
    PENDING,
    COUNTERED,
    ACCEPTED,
    REJECTED,
    EXPIRED,
    WITHDRAWN
}