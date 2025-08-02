package com.ejada.ecommerce.shop_service_second.Repository;

import com.ejada.ecommerce.shop_service_second.data.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
