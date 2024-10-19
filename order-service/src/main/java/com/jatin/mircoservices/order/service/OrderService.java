package com.jatin.mircoservices.order.service;

import com.jatin.mircoservices.order.dto.OrderRequest;
import com.jatin.mircoservices.order.dto.OrderResponse;

public interface OrderService {
    public OrderResponse placeOrder(OrderRequest orderRequest);
}
