package com.jatin.mircoservices.inventory.dto;

public record InventoryRequest(Long id, String skuCode, Integer quantity) {
}
