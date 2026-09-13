# Automotive Vehicle Marketplace

A modular, domain-driven backend system for a digital automotive marketplace supporting vehicle discovery, offer negotiations, reservations, inspections, financing applications, and post-sale reviews.

---

## Domain Architecture & Entities

### System Actors & Roles

**Primary Actors**
* **Buyer:** Discovers vehicles, submits offers/bids, books test drives, and initiates purchase or loan applications.
* **Seller:** Individual owner listing personal vehicles for sale or lease.
* **Dealer:** Business seller managing multi-vehicle inventory, promotions, and dealership profiles.
* **Admin:** System administrator handling user KYC verifications, listing moderations, and account management.

**Supporting Actors**
* **Inspector:** Conducts vehicle inspections, records chassis/odometer metrics, and uploads technical audit reports.
* **Delivery Agent:** Manages vehicle pickup, delivery status, and order completion fulfillment.
* **Finance Partner:** Evaluates and processes buyer loan applications.
* **Insurance Partner:** Handles policy applications and coverage verifications.
* **Support Agent:** Assists users with platform disputes and ticket inquiries.

---

### Core Objects & Modules

* **User & Dealership:** `User`, `Dealership`, `Document` (KYC, RC, Insurance, PUC).
* **Inventory & Listing:** `Vehicle`, `VehicleListing`, `VehicleCategory`, `Showroom`.
* **Negotiation & Sales:** `Offer/Bid`, `Booking/Order`, `Payment`, `Invoice`.
* **Services & Support:** `InspectionReport`, `TestDriveRequest`, `LoanApplication`.
* **Engagement & Communication:** `ChatMessage`, `Wishlist`, `Review`, `Notification`, `SearchFilter`.

---

## Workflow & Business Rules

### Vehicle Listing Lifecycle

```text
[Draft] ──> publishListing ──> [PendingApproval] ──> approveReport & Admin Approval ──> [Active]
                                                                                           │
[Sold] <── paymentSuccess <── [Reserved] <── createBooking/acceptOffer ────────────────────┘
```
KYC Mandate: Sellers and Dealers must complete KYC verification before publishing listings.

Technical Audits: Listings transition to Active state only after an InspectionReport is approved.

Offer Dynamics: Accepting a buyer offer automatically invalidates other pending offers on the same listing.

Reservation Lock: Creating a booking transitions the listing to Reserved status to prevent duplicate sales.

Tech Stack
Language: Java

Framework: Spring Boot

Architecture: Domain-Driven Design (DDD), Modular Monolith

API Protocol: RESTful Services

Build Automation: Apache Maven

License
Distributed under the MIT License. See LICENSE for details.
