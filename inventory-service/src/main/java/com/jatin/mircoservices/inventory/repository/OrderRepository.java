package com.jatin.mircoservices.inventory.repository;

import com.jatin.mircoservices.inventory.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Inventory, Long> {
}
