package com.sudipto.productcatalogservice.dtos;

import com.sudipto.productcatalogservice.models.Products;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDTO {
    private Long id;
    private String title;
    private String description;
    private String image;
    private Double price;
    private String category;

    public Products covertToProducts(){
        Products products = new Products();
        products.setName(this.title);
        products.setDescription(this.description);
        products.setCategory(this.category);
        products.setPrice(this.price);
        products.setId(this.id);

        return products;
    }
}