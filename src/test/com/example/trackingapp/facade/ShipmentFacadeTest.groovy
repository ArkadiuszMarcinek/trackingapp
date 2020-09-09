package com.example.trackingapp.facade

import com.example.trackingapp.configs.ShipmentFacadeConfiguration
import com.example.trackingapp.models.dto.Shipment
import com.example.trackingapp.strategy.ShipmentStatusStrategy
import spock.lang.Specification
import testutils.RequestUtilsForTest

class ShipmentFacadeTest extends Specification {
    def shipmentStatus = Mock(ShipmentStatusStrategy)
    def facade = new ShipmentFacadeConfiguration(shipmentStatus).testShipmentFacade()


    def "should create shippment order in the database"() {

        given: "sample request is prepared"
        def shipment = Shipment.builder()
                .recipient(RequestUtilsForTest.getRecipient())
                .sender(RequestUtilsForTest.getSender())
                .build()

        when: "shipment is orderred"
        def result = facade.orderShipment(shipment)

        then: "system finalize the ordering"
        noExceptionThrown()
        result.postDate != null
        result.trackingNumber != null
        result.sender == RequestUtilsForTest.sender
        result.recipient == RequestUtilsForTest.recipient

    }

    def "FindShipmentByTrackingNumber"() {
    }

    def "OrderShipment"() {
    }

    def "ChangeShipmentStatus"() {
    }
}
