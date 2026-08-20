#
## ACTORS / USERS (প্রস্তাবিত)

Buyer
Seller
Dealer
Admin
Inspector
Support Agent
Delivery Agent
Finance Partner
Insurance Partner
------------------------------------------------------------------------------------------

## OBJECTS (প্রস্তাবিত)

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

#
═══════════════════════════════════════════
USER
═══════════════════════════════════════════

ATTRIBUTES

userId
name
email
phone 
passwordHash
role (Buyer / Seller / Dealer / Admin / Inspector / DeliveryAgent)
profilePicture
address, city
isVerified
kycStatus
rating (avg)
dealershipId (nullable, dealer hole)
createdAt

RELATIONSHIPS — OBJECT

CARDINALITY        OBJECT
1 : N               VehicleListing 
1 : N               Offer/Bid 
1 : N               Wishlist
1 : N               Chat/Message
1 : N               Review 
1 : N               Review 
1 : N               Booking/Order
1 : N               Notification
1 : 1               Dealership (optional)

RELATIONSHIPS — ACTOR / USER

CARDINALITY        ACTOR / USER
1 : N               Admin (moderates/suspends users)
1 : 1               Inspector (self, if role=Inspector)

ACTIONS

register()                  → Buyer, Seller, Dealer
login() / logout()          → All
updateProfile()              → All
submitKYC()                  → Seller, Dealer
verifyKYC()                  → Admin
suspendUser()                 → Admin
deleteAccount()               → All, Admin

STATE

Unverified
Verified
Suspended
Deleted

STATE TRANSITIONS

Unverified → submitKYC → PendingReview
PendingReview → verifyKYC(Admin) → Verified
Verified → suspendUser(Admin) → Suspended
Suspended → reinstate(Admin) → Verified
Verified/Suspended → deleteAccount → Deleted

BUSINESS RULES

Email/phone unique per account
Dealer role requires dealership registration proof
Seller must be KYC-verified before publishing a listing
Suspended user cannot post listing/offer/chat

#
═══════════════════════════════════════════
VEHICLE LISTING
═══════════════════════════════════════════

ATTRIBUTES

listingId
sellerId
vehicleId
price
description
images[]
location
status (Draft/PendingApproval/Active/Reserved/Sold/Expired/Removed)
isFeatured
viewCount
postedAt
expiresAt

RELATIONSHIPS — OBJECT

CARDINALITY        OBJECT
N : 1               User (seller)
1 : 1               Vehicle
1 : N               Offer/Bid
1 : N               Chat/Message
1 : 1               InspectionReport
1 : N               Wishlist
1 : N               TestDriveRequest

RELATIONSHIPS — ACTOR / USER

CARDINALITY        ACTOR / USER
N : 1               Seller / Dealer (owner)
N : N               Buyer (viewers)
N : 1               Admin (moderator)
1 : 1               Inspector (assigned)

ACTIONS

createListing()               → Seller, Dealer
editListing()                  → Seller, Dealer
publishListing()               → Seller, Dealer
approveListing()               → Admin
markAsSold()                    → Seller, Dealer, System
removeListing() / reportListing() → Seller, Buyer, Admin
boostListing()                  → Dealer

STATE

Draft
PendingApproval
Active
Reserved
Sold
Expired
Removed

STATE TRANSITIONS

Draft → publishListing → PendingApproval
PendingApproval → approveListing(Admin) → Active
Active → createBooking → Reserved
Reserved → paymentSuccess → Sold
Reserved → cancelBooking → Active
Active → autoExpire(System) → Expired
Draft/PendingApproval/Active → removeListing → Removed

BUSINESS RULES

Only KYC-verified Seller/Dealer can publish
Listing goes Active only after InspectionReport approved (if mandatory)
Auto-expire after 30/60 days if unsold
Sold/Removed listing is immutable
#
═══════════════════════════════════════════
VEHICLE
═══════════════════════════════════════════

ATTRIBUTES

vehicleId
make, model, variant, year
mileage
fuelType
transmission
color
registrationNumber
chassisNumber
ownerCount
condition (New/Used)

RELATIONSHIPS — OBJECT

CARDINALITY        OBJECT
1 : 1               VehicleListing
1 : N               Document (RC, Insurance, PUC)
1 : 1               InspectionReport

RELATIONSHIPS — ACTOR / USER

CARDINALITY        ACTOR / USER
N : 1               Seller (data entry)
N : 1               Inspector (verification)

ACTIONS

addVehicleDetails()      → Seller, Dealer
updateVehicleDetails()   → Seller, Dealer
verifyRegistration()      → Inspector, Admin

BUSINESS RULES

registrationNumber must be unique across active listings
chassisNumber verification mandatory before listing = Active
ownerCount, year cannot be edited after inspection approved
#
═══════════════════════════════════════════
OFFER / BID
═══════════════════════════════════════════

ATTRIBUTES

offerId
listingId
buyerId
offerAmount
counterAmount
message
status (Pending/Countered/Accepted/Rejected/Expired/Withdrawn)
createdAt
expiresAt

RELATIONSHIPS — OBJECT

CARDINALITY        OBJECT
N : 1               VehicleListing
N : 1               User (buyer)
1 : 1               Booking/Order (if accepted)

RELATIONSHIPS — ACTOR / USER

CARDINALITY        ACTOR / USER
N : 1               Buyer (creator)
N : 1               Seller/Dealer (responder)

ACTIONS

makeOffer()          → Buyer
acceptOffer()         → Seller, Dealer
rejectOffer()          → Seller, Dealer
counterOffer()          → Seller, Dealer
withdrawOffer()          → Buyer

STATE

Pending
Countered
Accepted
Rejected
Expired
Withdrawn

STATE TRANSITIONS

Pending → counterOffer → Countered
Pending/Countered → acceptOffer → Accepted
Pending → rejectOffer → Rejected
Pending → autoExpire → Expired
Pending → withdrawOffer(Buyer) → Withdrawn
Accepted → createBooking(System) → (triggers Booking)

BUSINESS RULES

One active offer per buyer per listing
Accepting an offer auto-rejects other pending offers on same listing
Offer auto-expires after X days
#
═══════════════════════════════════════════
BOOKING / ORDER
═══════════════════════════════════════════

ATTRIBUTES

orderId
listingId
buyerId
sellerId
agreedPrice
bookingDate
deliveryMode
status (Initiated/PaymentPending/Confirmed/OutForDelivery/Completed/Cancelled)

RELATIONSHIPS — OBJECT

CARDINALITY        OBJECT
1 : 1               VehicleListing
1 : 1               Payment
1 : 1               Invoice
1 : 1               Review (post-completion)

RELATIONSHIPS — ACTOR / USER

CARDINALITY        ACTOR / USER
N : 1               Buyer
N : 1               Seller/Dealer
N : 1               Admin (oversight)
1 : 1               DeliveryAgent (assigned)

ACTIONS

createBooking()          → Buyer, System
confirmBooking()          → Seller, Dealer
assignDeliveryAgent()      → Admin
cancelBooking()             → Buyer, Seller, Admin
completeBooking()            → DeliveryAgent, System

STATE

Initiated
PaymentPending
Confirmed
OutForDelivery
Completed
Cancelled

STATE TRANSITIONS

Initiated → makePayment → PaymentPending
PaymentPending → paymentSuccess → Confirmed
Confirmed → assignDeliveryAgent → OutForDelivery
OutForDelivery → deliverVehicle → Completed
Initiated/PaymentPending/Confirmed → cancelBooking → Cancelled

BUSINESS RULES

Booking reserves listing (Listing.status = Reserved)
Auto-cancel if payment not completed within X hours
Cancellation after Confirmed follows refund policy
#
═══════════════════════════════════════════
PAYMENT
═══════════════════════════════════════════

ATTRIBUTES

paymentId
orderId
amount
paymentMode
transactionRef
status (Initiated/Success/Failed/Refunded)
paidAt

RELATIONSHIPS — OBJECT

CARDINALITY        OBJECT
1 : 1               Booking/Order
1 : 1               Invoice

RELATIONSHIPS — ACTOR / USER

CARDINALITY        ACTOR / USER
N : 1               Buyer (payer)
N : 1               FinancePartner (if loan-based)
N : 1               Admin (refund approval)

ACTIONS

initiatePayment()        → Buyer
verifyPayment()           → System, PaymentGateway
refundPayment()            → Admin

STATE

Initiated
Success
Failed
Refunded

STATE TRANSITIONS

Initiated → gatewaySuccess → Success
Initiated → gatewayFail → Failed
Success → refundApproved(Admin) → Refunded

BUSINESS RULES

Payment operation must be idempotent
Refund allowed only within policy window
Partial/token payment supported before full settlement

#
═══════════════════════════════════════════
INSPECTION REPORT
═══════════════════════════════════════════

ATTRIBUTES

reportId
vehicleId
inspectorId
checklistData (JSON)
overallScore
remarks
reportUrl (PDF)
reportDate

RELATIONSHIPS — OBJECT

CARDINALITY        OBJECT
1 : 1               Vehicle
1 : 1               VehicleListing

RELATIONSHIPS — ACTOR / USER

CARDINALITY        ACTOR / USER
N : 1               Inspector (creator)
N : 1               Admin (approver)
N : N               Buyer/Seller (viewers)

ACTIONS

scheduleInspection()          → Seller, Admin
submitInspectionReport()       → Inspector
approveReport()                  → Admin
rejectReport()                     → Admin

STATE

Scheduled
InProgress
Submitted
Approved
Rejected

STATE TRANSITIONS

Scheduled → startInspection → InProgress
InProgress → submitReport → Submitted
Submitted → approveReport(Admin) → Approved
Submitted → rejectReport(Admin) → Rejected

BUSINESS RULES

Listing can't become Active without an Approved report (if mandatory feature)
Report valid only for X days, then re-inspection required

#
═══════════════════════════════════════════
CHAT / MESSAGE
═══════════════════════════════════════════

ATTRIBUTES

messageId
threadId
listingId
senderId
receiverId
content
sentAt
isRead

RELATIONSHIPS — OBJECT

CARDINALITY        OBJECT
N : 1               VehicleListing

RELATIONSHIPS — ACTOR / USER

CARDINALITY        ACTOR / USER
N : N               Buyer ↔ Seller/Dealer
N : 1               Admin (moderation only)

ACTIONS

sendMessage()        → Buyer, Seller, Dealer
markAsRead()          → Buyer, Seller, Dealer
blockUser()             → Buyer, Seller, Dealer
reportChat()              → Buyer, Seller, Admin

BUSINESS RULES

Chat tied to a specific listing thread
Abusive/spam content auto-flagged for Admin review
Contact-info sharing may be restricted by platform policy
#
═══════════════════════════════════════════
REVIEW / RATING
═══════════════════════════════════════════

ATTRIBUTES

reviewId
orderId
reviewerId
revieweeId
rating (1–5)
comment
createdAt

RELATIONSHIPS — OBJECT

CARDINALITY        OBJECT
1 : 1               Booking/Order

RELATIONSHIPS — ACTOR / USER

CARDINALITY        ACTOR / USER
N : 1               Buyer / Seller / Dealer (reviewer & reviewee, both directions)
N : 1               Admin (moderation)

ACTIONS

submitReview()        → Buyer, Seller, Dealer
editReview()            → Reviewer
deleteReview()            → Reviewer, Admin
reportReview()              → Any User, Admin

BUSINESS RULES

Review allowed only after Order.status = Completed
One review per order per direction (buyer→seller, seller→buyer)
User.rating auto-recalculated on new review
#
═══════════════════════════════════════════
WISHLIST
═══════════════════════════════════════════

ATTRIBUTES

wishlistId
buyerId
listingId
addedAt

RELATIONSHIPS — OBJECT

CARDINALITY        OBJECT
N : 1               User (buyer)
N : 1               VehicleListing

ACTIONS

addToWishlist()          → Buyer
removeFromWishlist()       → Buyer

BUSINESS RULES

No duplicate (buyerId + listingId) entry
Auto-remove entry if listing becomes Sold/Removed
#
═══════════════════════════════════════════
NOTIFICATION
═══════════════════════════════════════════

ATTRIBUTES

notificationId
userId
type
title, message
referenceId
isRead
createdAt

RELATIONSHIPS — OBJECT

CARDINALITY        OBJECT
N : 1               User

ACTIONS

sendNotification()          → System
markAsRead()                  → All Users
deleteNotification()            → All Users

BUSINESS RULES

Triggered by system events: new offer, price-drop, booking-confirmed, payment-status, etc.
Delivery channel: Push / Email / SMS — user preference based