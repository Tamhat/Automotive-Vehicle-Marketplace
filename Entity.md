ACTORS / USERS (প্রস্তাবিত)

Buyer
Seller
Dealer
Admin
Inspector
Support Agent
Delivery Agent
Finance Partner
Insurance Partner
-------------------------------------------------------------------------------------------------

OBJECTS (প্রস্তাবিত)

User
vehicle
vehiclelisting
VehicleCategory
Offer
Booking
Order
Payment
Invoice
Inspection Report
Document
Review
ChatMessage
Wishlist
SearchFilter
Notification
TestDrive Request
Loan Application
Showroom
--------------------------------------------------


Primary Actors:

Buyer — vehicle khoje, browse kore, kine
Seller — individual, নিজের vehicle বিক্রি করে
Dealer — business/showroom, multiple vehicles list kore
Admin — platform manage kore, moderation kore

Supporting Actors:
5. Inspector / Verification Agent — vehicle physically check kore report dey
6. Support Agent / CS — customer query handle kore
7. Delivery Agent — vehicle handover/logistics
8. Finance Partner (Bank/NBFC) — loan approve kore (jodi financing feature thake)
9. Insurance Partner — insurance offer kore (optional feature)

Core Objects:

1. User (base — buyer/seller/dealer shared attributes)
2. Vehicle — actual vehicle details (make, model, variant, year)
3. Vehicle Listing — main object, ekta gari post
4. VehicleCategory — Car / Bike / Truck / Commercial

Transaction-related:
5. Offer / Bid — buyer price propose kore
6. Booking / Reservation — deal lock kora
7. Order / Transaction — final purchase record
8. Payment
9. Invoice

Trust & Verification:
10. Inspection Report
11. Document (RC book, insurance papers, tax token)
12. Review / Rating

Engagement:
13. Chat / Message — buyer-seller communication
14. Wishlist / SavedListing
15. SearchFilter / SavedSearch
16. Notification

Optional (feature scope depend kore):
17. TestDrive Request
18. Loan Application
19. Showroom / Dealership (jodi dealer er physical location thake)