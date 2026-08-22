package com.automotive.marketplace.controller;

import com.automotive.marketplace.entity.Offer;
import com.automotive.marketplace.repository.OfferRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/offers")
@RequiredArgsConstructor
public class OfferController {

    private final OfferRepository offerRepository;

    @GetMapping
    public ResponseEntity<List<Offer>> getAll() {
        return ResponseEntity.ok(offerRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Offer> getById(@PathVariable String id) {
        return offerRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Offer> create(@Valid @RequestBody Offer entity) {
        Offer savedEntity = offerRepository.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Offer> update(@PathVariable String id, @Valid @RequestBody Offer entity) {
        if (!offerRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        Offer updatedEntity = offerRepository.save(entity);
        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (!offerRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        offerRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
