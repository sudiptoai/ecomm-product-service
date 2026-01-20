package com.sudipto.productcatalogservice.services;

import com.sudipto.productcatalogservice.dtos.FakeStoreProductDTO;
import com.sudipto.productcatalogservice.dtos.ProductResponseDTO;
import com.sudipto.productcatalogservice.models.Products;
import com.sudipto.productcatalogservice.repositories.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    private RestTemplate restTemplate;

    public ProductServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Products> getAllProducts() {
        // get all product from a thirdparty api using restTemplate
        ResponseEntity<FakeStoreProductDTO[]> fakeStoreProductDTOResponse = restTemplate.getForEntity("https://fakestoreapi.com/products", FakeStoreProductDTO[].class);
        List<Products> products = new ArrayList<>();
        for (FakeStoreProductDTO fakeStoreProductDTO : fakeStoreProductDTOResponse.getBody()) {
            products.add(fakeStoreProductDTO.covertToProducts());
        }
        products.add(new Products());
        return products;
    }

    @Override
    public List<Products> getAllProductsByCategory(String category) {
        ResponseEntity<FakeStoreProductDTO[]> fakeStoreProductsByCategory = restTemplate.getForEntity("https://fakestoreapi.com/products/category/" + category, FakeStoreProductDTO[].class);
        List<Products> products = new ArrayList<>();
        for (FakeStoreProductDTO fakeStoreProduct: fakeStoreProductsByCategory.getBody()){
            products.add(fakeStoreProduct.covertToProducts());
        }
        return products;
    }

    @Override
    public Products getProductsById(Long id) {
        ResponseEntity<FakeStoreProductDTO> fakeProduct = restTemplate.getForEntity("https://fakestoreapi.com/products/" + id, FakeStoreProductDTO.class, id);
        FakeStoreProductDTO fakeStoreProductDTO = fakeProduct.getBody();
        if(fakeProduct.getBody() != null) {
            return fakeStoreProductDTO.covertToProducts();
        }
        return null;
    }
}
