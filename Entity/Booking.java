package Entity;

enum InspectionReportState {
    SCHEDULED,
    IN_PROGRESS,
    SUBMITTED,
    APPROVED,
    REJECTED
}

public class Booking {
    private String orderId;
    private String listingId;
    private String buyerId;
    private String sellerId;
    private double agreedPrice;
    private java.time.LocalDate bookingDate;
    private String deliveryMode;
    private InspectionReportState status;

}
