public class VehicleListing {

    
private String listingId;
private String sellerId;
private String vehicleId;
private double price;
private String description;
private String[] images;
private String location;
private ListingStatus status; // Draft/PendingApproval/Active/Reserved/Sold/Expired/Removed
private boolean isFeatured;
private int viewCount;
private java.time.LocalDateTime postedAt;
private java.time.LocalDateTime expiresAt;



    public static enum ListingStatus {

    DRAFT,
    PENDING_APPROVAL,
    ACTIVE,
    RESERVED,
    SOLD,
    EXPIRED,
    REMOVED
    }
}