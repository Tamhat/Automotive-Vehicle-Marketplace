package com.automotive.marketplace.repository;

import java.util.List;
import java.util.Optional;

public interface VehicleRepository {
    Vehicle save(Vehicle entity);
    Optional<Vehicle> findById(String id);
    List<Vehicle> findAll();
    void deleteById(String id);
    boolean existsById(String id);
    long count();
}
