package com.example.trackingapp.facade

import com.example.trackingapp.configs.ShipmentFacadeConfiguration
import spock.lang.Specification

class ShipmentFacadeSpec extends Specification {
    def strategyOrder = Mock(ShipmentFacade)
    def facade = new ShipmentFacadeConfiguration(strategyOrder).testShipmentFacade()

    def "FindShipmentBaseByTrackingNumber"() {

    }

    def "FindShipmentByTrackingNumber"() {
    }

    def "OrderShipment"() {
    }

    def "ChangeShipmentStatus"() {
    }
}
