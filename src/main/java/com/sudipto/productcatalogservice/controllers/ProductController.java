package com.sudipto.productcatalogservice.controllers;

import com.sudipto.productcatalogservice.dtos.ProductResponseDTO;
import com.sudipto.productcatalogservice.models.Products;
import com.sudipto.productcatalogservice.services.IProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private IProductService productService;
    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductResponseDTO>> getAllProduct() {
        List<Products> products = productService.getAllProducts();
        List<ProductResponseDTO> productResponseDTOList = new ArrayList<>();
        for (Products product : products) {
            productResponseDTOList.add(product.toProductResponseDTO());
        }
        return ResponseEntity.ok(productResponseDTOList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable Long id) {
        Products product = productService.getProductsById(id);
        ProductResponseDTO productResponseDTO = product.toProductResponseDTO();

        return ResponseEntity.ok(productResponseDTO);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<ProductResponseDTO>> getProductsByCategory(@PathVariable String category) {
        List<Products> products = productService.getAllProductsByCategory(category);
        List<ProductResponseDTO> productResponseDTOList = new ArrayList<>();
        for (Products product : products) {
            productResponseDTOList.add(product.toProductResponseDTO());
        }
        return ResponseEntity.ok(productResponseDTOList);
    }
}
