package com.example.trackingapp.services;

import com.example.trackingapp.exceptions.SenderNotFoundException;
import com.example.trackingapp.models.dto.Sender;
import com.example.trackingapp.utils.ShipmentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class SenderService {

    private final SenderRepository senderRepository;

    Sender findSenderById(UUID senderId) {

        return senderRepository.findSenderById(senderId)
                .map(ShipmentMapper::map)
                .orElseThrow(SenderNotFoundException::new);
    }
}
