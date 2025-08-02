package com.ejada.ecommerce.wallet_service_first.repos;

import com.ejada.ecommerce.wallet_service_first.data.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
