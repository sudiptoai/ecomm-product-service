package com.sudipto.productcatalogservice.services;

import com.sudipto.productcatalogservice.models.Products;

import java.util.List;

public interface IProductService {
    List<Products> getAllProducts();
    List<Products> getAllProductsByCategory(String category);
    Products getProductsById(Long id);
}
