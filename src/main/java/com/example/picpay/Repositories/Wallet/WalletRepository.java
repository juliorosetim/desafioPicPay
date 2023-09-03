package com.example.picpay.Repositories.Wallet;

import com.example.picpay.Entity.wallet.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<WalletEntity, Long> {

    WalletEntity findWalletByUserId(Long userId);
}
