package com.ejada.ecommerce.shop_service_first.Repository;

import com.ejada.ecommerce.shop_service_first.data.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {


     Product findByName(String username);
}
