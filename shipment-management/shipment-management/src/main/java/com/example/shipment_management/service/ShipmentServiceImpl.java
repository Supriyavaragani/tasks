package com.example.shipment_management.service;

import com.example.shipment_management.entity.Shipment;
import com.example.shipment_management.repository.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShipmentServiceImpl implements ShipmentService {

    @Autowired
    private ShipmentRepository shipmentRepository;

    @Override
    public Optional<Shipment> getShipmentByTrackNo(String trackNo) {
        return shipmentRepository.findByTrackNo(trackNo);
    }

    @Override
    public void deleteShipmentById(Integer shipId) throws Exception {
        Optional<Shipment> shipment = shipmentRepository.findById(shipId);
        if (shipment.isPresent()) {
            shipmentRepository.deleteById(shipId);
        } else {
            throw new Exception("Shipment not found");
        }
    }

    @Override
    public Shipment saveShipment(Shipment shipment) {
        return shipmentRepository.save(shipment);
    }
}

