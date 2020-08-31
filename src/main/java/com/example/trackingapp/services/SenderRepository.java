package com.example.trackingapp.services;

import com.example.trackingapp.models.SenderEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.Optional;
import java.util.UUID;

public interface SenderRepository extends Repository<SenderEntity, Long> {

    @Query(value = "SELECT * FROM SENDER S WHERE S.SENDER_ID = :senderId", nativeQuery = true)
    Optional<SenderEntity> findSenderById(UUID senderId);
}
