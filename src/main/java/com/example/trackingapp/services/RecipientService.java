package com.example.trackingapp.services;

import com.example.trackingapp.exceptions.RecipientNotFoundException;
import com.example.trackingapp.models.dto.Recipient;
import com.example.trackingapp.utils.ShipmentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class RecipientService {

    private final RecipientRepository recipientRepository;

    public Recipient findRecipientById(UUID recipientById) {
        return recipientRepository.findRecipientById(recipientById)
                .map(ShipmentMapper::map)
                .orElseThrow(RecipientNotFoundException::new);

    }
}
