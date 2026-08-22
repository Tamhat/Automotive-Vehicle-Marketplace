package com.automotive.marketplace.controller;

import com.automotive.marketplace.entity.InspectionReport;
import com.automotive.marketplace.repository.InspectionReportRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inspection-reports")
@RequiredArgsConstructor
public class InspectionReportController {

    private final InspectionReportRepository inspectionReportRepository;

    @GetMapping
    public ResponseEntity<List<InspectionReport>> getAll() {
        return ResponseEntity.ok(inspectionReportRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InspectionReport> getById(@PathVariable String id) {
        return inspectionReportRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<InspectionReport> create(@Valid @RequestBody InspectionReport entity) {
        InspectionReport savedEntity = inspectionReportRepository.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InspectionReport> update(@PathVariable String id, @Valid @RequestBody InspectionReport entity) {
        if (!inspectionReportRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        InspectionReport updatedEntity = inspectionReportRepository.save(entity);
        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (!inspectionReportRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        inspectionReportRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
