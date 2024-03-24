package org.example.springannotationpractic.repository;

import org.example.springannotationpractic.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> allProducts = new ArrayList<>(){{
        add(Product.builder()
                .id(1)
                .title("product title one ")
                .description("this is the product one description")
                .price(3.4f)
                .imageURL("productimageone.jpg")
                .build());
        add(Product.builder()
                .id(2)
                .title("product title two ")
                .description("this is the product two description")
                .price(3.4f)
                .imageURL("productimagetwo.jpg")
                .build());
        add(Product.builder()
                .id(3)
                .title("product title three ")
                .description("this is the product one description")
                .price(3.4f)
                .imageURL("productimagethree.jpg")
                .build());
    }};
    public List<Product> getAllProducts(){
        return allProducts;
    }
    public void addProduct(Product product){
        allProducts.add(product);
    }
}
