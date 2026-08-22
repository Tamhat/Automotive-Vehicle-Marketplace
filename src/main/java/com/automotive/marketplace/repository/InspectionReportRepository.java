package com.automotive.marketplace.repository;

import java.util.List;
import java.util.Optional;

public interface InspectionReportRepository {
    InspectionReport save(InspectionReport entity);
    Optional<InspectionReport> findById(String id);
    List<InspectionReport> findAll();
    void deleteById(String id);
    boolean existsById(String id);
    long count();
}
