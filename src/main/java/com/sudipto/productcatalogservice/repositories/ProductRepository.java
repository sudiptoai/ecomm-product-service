package com.sudipto.productcatalogservice.repositories;

import com.sudipto.productcatalogservice.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {
}
