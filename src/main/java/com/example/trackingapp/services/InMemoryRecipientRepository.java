package com.example.trackingapp.services;

import com.example.trackingapp.models.RecipientEntity;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryRecipientRepository implements RecipientRepository {

    private final Map<UUID, RecipientEntity> db = new ConcurrentHashMap<>();

    @Override
    public Optional<RecipientEntity> findRecipientById(UUID recipientId) {
        return Optional.ofNullable(db.get(recipientId));
    }
}
