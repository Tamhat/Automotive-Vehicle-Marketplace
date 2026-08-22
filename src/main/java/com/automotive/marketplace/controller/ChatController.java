package com.automotive.marketplace.controller;

import com.automotive.marketplace.entity.Chat;
import com.automotive.marketplace.repository.ChatRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/chats")
@RequiredArgsConstructor
public class ChatController {

    private final ChatRepository chatRepository;

    @GetMapping
    public ResponseEntity<List<Chat>> getAll() {
        return ResponseEntity.ok(chatRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Chat> getById(@PathVariable String id) {
        return chatRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Chat> create(@Valid @RequestBody Chat entity) {
        Chat savedEntity = chatRepository.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Chat> update(@PathVariable String id, @Valid @RequestBody Chat entity) {
        if (!chatRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        Chat updatedEntity = chatRepository.save(entity);
        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (!chatRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        chatRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
