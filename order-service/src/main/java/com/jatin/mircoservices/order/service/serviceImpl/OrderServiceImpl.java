package com.jatin.mircoservices.order.service.serviceImpl;

import com.jatin.mircoservices.order.dto.OrderRequest;
import com.jatin.mircoservices.order.dto.OrderResponse;
import com.jatin.mircoservices.order.model.Order;
import com.jatin.mircoservices.order.repository.OrderRepository;
import com.jatin.mircoservices.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public OrderResponse placeOrder(OrderRequest orderRequest) {
        Order order = Order.builder()
                .orderNumber(orderRequest.orderNumber())
                .skuCode(orderRequest.skuCode())
                .price(orderRequest.price())
                .quantity(orderRequest.quantity())
                .build();

        Order savedOrder = orderRepository.save(order);
        return new OrderResponse(savedOrder.getId(), savedOrder.getOrderNumber(), savedOrder.getSkuCode(), savedOrder.getPrice(), savedOrder.getQuantity());
    }
}
