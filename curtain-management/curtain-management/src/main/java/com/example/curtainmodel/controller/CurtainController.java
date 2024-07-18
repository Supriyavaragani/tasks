package com.example.curtainmodel.controller;

import com.example.curtainmodel.entity.Curtain;
import com.example.curtainmodel.repository.CurtainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CurtainController {

    @Autowired
    private CurtainRepository curtainRepository;

    @GetMapping("/curtains/price")
    public List<Curtain> getCurtainsByPrice(@RequestParam int price) {
        return curtainRepository.getIdByPrice(price);
    }

    @GetMapping("/curtains/brand")
    public List<Curtain> getCurtainsByBrand(@RequestParam String brand) {
        return curtainRepository.getIdByBrand(brand);
    }
}
