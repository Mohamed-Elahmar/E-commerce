package com.ejada.ecommerce.wallet_service_first.repos;

import com.ejada.ecommerce.wallet_service_first.data.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByName(String username);

}
