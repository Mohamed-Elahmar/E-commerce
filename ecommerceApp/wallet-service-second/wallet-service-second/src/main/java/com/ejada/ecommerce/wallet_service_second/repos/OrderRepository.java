package com.ejada.ecommerce.wallet_service_second.repos;

import com.ejada.ecommerce.wallet_service_second.data.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
