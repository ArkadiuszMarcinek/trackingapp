package com.example.trackingapp.services;

import com.example.trackingapp.models.SenderEntity;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class InMemorySenderRepository implements SenderRepository {

    private final Map<UUID, SenderEntity> db = new ConcurrentHashMap<>();

    @Override
    public Optional<SenderEntity> findSenderById(UUID senderId) {
        return Optional.ofNullable(db.get(senderId));
    }
}
