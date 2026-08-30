package com.automotive.marketplace.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "inspection_reports")
public class InspectionReport {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "reportId is required")
    private String reportId;
    @NotBlank(message = "vehicleId is required")
    private String vehicleId;
    @NotBlank(message = "inspectorId is required")
    private String inspectorId;
    @NotBlank(message = "checklistData is required")
    private String checklistData;
    private double overallScore;
    @NotBlank(message = "remarks is required")
    private String remarks;
    private String reportUrl;
    private java.time.LocalDateTime reportDate;

}

