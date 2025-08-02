package com.ejada.ecommerce.shop_service_first.Repository;

import com.ejada.ecommerce.shop_service_first.data.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
