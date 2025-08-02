package com.ejada.ecommerce.wallet_service_second.repos;

import com.ejada.ecommerce.wallet_service_second.data.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByName(String username);

}
