package org.example.springannotationpractic.service;


import org.example.springannotationpractic.dto.ProductRequest;
import org.example.springannotationpractic.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    List<ProductResponse> getAllProduct(String productName);

    List<ProductResponse> getAllProduct();

    ProductResponse createProduct(ProductRequest productRequest);
    ProductResponse findProductByID(int id);
    void deleteProduct(int productId);
    ProductResponse updateProduct(int id, ProductRequest productRequest);

    ProductResponse updateProduct(ProductRequest productRequest);
}
