package com.automotive.marketplace.repository;

import com.automotive.marketplace.entity.InspectionReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InspectionReportRepository extends JpaRepository<InspectionReport, String> {
}
