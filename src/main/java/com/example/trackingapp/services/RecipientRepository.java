package com.example.trackingapp.services;

import com.example.trackingapp.models.RecipientEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.Optional;
import java.util.UUID;

public interface RecipientRepository extends Repository<RecipientEntity, Long> {

    @Query(value = "SELECT * FROM RECIPIENT R WHERE R.RECIPIENT_ID = :recipientId", nativeQuery = true)
    Optional<RecipientEntity> findRecipientById(UUID recipientId);
}
