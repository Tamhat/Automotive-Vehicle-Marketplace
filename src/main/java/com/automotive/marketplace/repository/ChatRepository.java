package com.automotive.marketplace.repository;

import java.util.List;
import java.util.Optional;

public interface ChatRepository {
    Chat save(Chat entity);
    Optional<Chat> findById(String id);
    List<Chat> findAll();
    void deleteById(String id);
    boolean existsById(String id);
    long count();
}
