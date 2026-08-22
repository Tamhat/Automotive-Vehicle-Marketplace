package com.automotive.marketplace.repository;

import java.util.List;
import java.util.Optional;

public interface OfferRepository {
    Offer save(Offer entity);
    Optional<Offer> findById(String id);
    List<Offer> findAll();
    void deleteById(String id);
    boolean existsById(String id);
    long count();
}
