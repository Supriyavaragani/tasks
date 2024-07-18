package com.example.shipment_management.service;

import com.example.shipment_management.entity.Shipment;
import java.util.Optional;

public interface ShipmentService {
    Optional<Shipment> getShipmentByTrackNo(String trackNo);
    void deleteShipmentById(Integer shipId) throws Exception;
    Shipment saveShipment(Shipment shipment);
}
