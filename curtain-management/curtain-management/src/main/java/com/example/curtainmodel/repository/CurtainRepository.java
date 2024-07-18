package com.example.curtainmodel.repository;

import com.example.curtainmodel.entity.Curtain;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CurtainRepository extends CrudRepository<Curtain, Integer> {

    // Task 1: Get curtains with price greater than given price
    @Query("SELECT c FROM Curtain c WHERE c.price > ?1")
    List<Curtain> getIdByPrice(int price);

    // Task 2: Get curtains with the given brand name
    @Query("SELECT c FROM Curtain c WHERE c.brand = ?1")
    List<Curtain> getIdByBrand(String brand);
}
