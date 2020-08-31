package com.example.trackingapp.configs;

import com.example.trackingapp.facade.ShipmentFacade;
import com.example.trackingapp.factory.ShipmentFactory;
import com.example.trackingapp.factory.ShipmentStatusFactory;
import com.example.trackingapp.services.InMemoryShipmentRepository;
import com.example.trackingapp.services.ShipmentRepository;
import com.example.trackingapp.services.ShipmentService;
import com.example.trackingapp.services.ShipmentUpdater;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ShipmentFacadeConfiguration {
    private final ShipmentStatusStrategy statusStrategy;
    ShipmentFacade testShipmentFacade() {
        return shipmentFacade(new InMemoryShipmentRepository());
    }

    @Bean
    ShipmentFacade shipmentFacade(ShipmentRepository shipmentRepository) {
        return new ShipmentFacade(
                new ShipmentService(
                        shipmentRepository,
                        new ShipmentFactory(new ShipmentStatusFactory()),
                        new ShipmentUpdater(statusStrategy)
                )
        );
    }
}
