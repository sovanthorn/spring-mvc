package org.example.springannotationpractic.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Product {
    private int id;
    private String title;
    private String description;
    private float price;
    private String imageURL;


}
