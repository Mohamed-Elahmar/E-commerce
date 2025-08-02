package com.ejada.ecommerce.wallet_service_second.repos;

import com.ejada.ecommerce.wallet_service_second.data.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WalletRepository extends JpaRepository<Wallet,Long> {

    Optional<Wallet> findById(Long id);

}
