package com.sudipto.productcatalogservice.models;

import com.sudipto.productcatalogservice.dtos.ProductResponseDTO;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Products extends BaseModel {
    private String name;
    private String description;
    private String category;
    private double price;

    public ProductResponseDTO toProductResponseDTO() {
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setName(name);
        productResponseDTO.setDescription(description);
        productResponseDTO.setCategory(category);
        productResponseDTO.setPrice(price);
        productResponseDTO.setId(this.getId());
        return productResponseDTO;
    }
}
