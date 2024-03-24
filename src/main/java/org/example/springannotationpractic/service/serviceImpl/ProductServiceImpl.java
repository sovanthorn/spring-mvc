package org.example.springannotationpractic.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.example.springannotationpractic.dto.ProductRequest;
import org.example.springannotationpractic.dto.ProductResponse;
import org.example.springannotationpractic.model.Product;
import org.example.springannotationpractic.repository.ProductRepository;
import org.example.springannotationpractic.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private ProductResponse mapProductToResponse(Product product){
        return ProductResponse.builder()
                .id(product.getId())
                .imageUrl(product.getImageUrl())
                .title(product.getTitle())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
    private Product mapRequestToProduct(ProductRequest request){
        return Product.builder()
                .title(request.title())
                .price(request.price())
                .imageUrl(request.imageUrl())
                .description(request.description())
                .build();
    }

    @Override
    public List<ProductResponse> getAllProduct() {
        return productRepository
                .getAllProducts()
                .stream()
                .map(pro->{
                    return ProductResponse.builder()
                            .id(pro.getId())
                            .imageUrl(pro.getImageURL())
                            .price(pro.getPrice())
                            .tltle(pro.getTitle())
                            .description(pro.getDescription())
                            .build();
                }).toList();
    }

    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {
        Product newProduct = mapRequestToProduct(request);
        var maxID= productRepository.getAllProducts()
                .stream()
                .max(Comparator.comparingInt(Product::getId))
                .map(Product::getId);
        int newID=1;
        if(maxID.isPresent()){
            newID =maxID.get()+1;
        }
        newProduct.setId(newID);
        productRepository.addProduct(newProduct);
        return mapProductToResponse(newProduct);
    }

    @Override
    public void deleteProduct(int productId) {

    }

    @Override
    public ProductResponse updateProduct(ProductRequest productRequest) {
        return null;
    }
}
