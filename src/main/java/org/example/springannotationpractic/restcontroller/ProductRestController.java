package org.example.springannotationpractic.restcontroller;

import lombok.RequiredArgsConstructor;
import org.example.springannotationpractic.dto.ProductRequest;
import org.example.springannotationpractic.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductRestController {
    private final ProductService productService;
    @GetMapping("/get-all")
    public Map<String, Object>getAlllProduct(){
        HashMap<String, Object> response= new HashMap<>();
        response.put("payload", productService.getAllProduct());
        response.put("message","Retrieved Data Successfully!");
        response.put("Status", HttpStatus.OK.value());
        return response;
    }
    @PostMapping("/new-product")
    public Map<String, Object> createNewProduct(@RequestBody ProductRequest request){
        HashMap<String, Object> response = new HashMap<>();
        response.put("payload", productService.createProduct(request));
        response.put("message", "Created New Product Successfully!");
        response.put("status", HttpStatus.CREATED.value());
        return response;
    }
}
