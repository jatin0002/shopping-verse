package com.jatin.mircoservices.product.service.serviceImpl;

import com.jatin.mircoservices.product.dto.ProductRequest;
import com.jatin.mircoservices.product.dto.ProductResponse;
import com.jatin.mircoservices.product.exceptions.ResourceNotFoundException;
import com.jatin.mircoservices.product.model.Product;
import com.jatin.mircoservices.product.repository.ProductRepository;
import com.jatin.mircoservices.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();

        productRepository.save(product);
        log.info("Product is created successfully");
        return new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice());
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(p -> new ProductResponse(p.getId(), p.getName(), p.getDescription(), p.getPrice()))
                .toList();
    }

    @Override
    public ProductResponse getProduct(String productId) {
        Optional<Product> product = productRepository.findById(productId);

        if (product.isEmpty()) {
            throw new ResourceNotFoundException("Product is not found with id: " + productId);
        }

        return new ProductResponse(product.get().getId(),
                product.get().getName(),
                product.get().getDescription(),
                product.get().getPrice());
    }

}
