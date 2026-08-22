package com.automotive.marketplace.controller;

import com.automotive.marketplace.entity.VehicleListing;
import com.automotive.marketplace.repository.VehicleListingRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicle-listings")
@RequiredArgsConstructor
public class VehicleListingController {

    private final VehicleListingRepository vehicleListingRepository;

    @GetMapping
    public ResponseEntity<List<VehicleListing>> getAll() {
        return ResponseEntity.ok(vehicleListingRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleListing> getById(@PathVariable String id) {
        return vehicleListingRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<VehicleListing> create(@Valid @RequestBody VehicleListing entity) {
        VehicleListing savedEntity = vehicleListingRepository.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehicleListing> update(@PathVariable String id, @Valid @RequestBody VehicleListing entity) {
        if (!vehicleListingRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        VehicleListing updatedEntity = vehicleListingRepository.save(entity);
        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (!vehicleListingRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        vehicleListingRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
