package com.automotive.marketplace.repository;

import java.util.List;
import java.util.Optional;

public interface VehicleListingRepository {
    VehicleListing save(VehicleListing entity);
    Optional<VehicleListing> findById(String id);
    List<VehicleListing> findAll();
    void deleteById(String id);
    boolean existsById(String id);
    long count();
}
