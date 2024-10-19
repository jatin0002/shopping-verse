package com.jatin.mircoservices.product.service;

import com.jatin.mircoservices.product.dto.ProductRequest;
import com.jatin.mircoservices.product.dto.ProductResponse;

import java.util.List;

public interface ProductService {

    public ProductResponse createProduct(ProductRequest productRequest);

    public List<ProductResponse> getAllProducts();

    public ProductResponse getProduct(String productId);

}
