package com.ejada.ecommerce.shop_service_second.Repository;

import com.ejada.ecommerce.shop_service_second.data.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {


     Product findByName(String username);
}
