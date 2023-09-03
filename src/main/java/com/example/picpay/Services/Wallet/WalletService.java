package com.example.picpay.Services.Wallet;


import com.example.picpay.Entity.wallet.WalletEntity;

import java.math.BigDecimal;
import java.util.List;

public interface WalletService {
    List<WalletEntity> getAllWallet() throws Exception;

    WalletEntity walletSave(WalletEntity walletEntity) throws Exception;

    WalletEntity findWalletByUserId(Long userId) throws Exception;

    WalletEntity entryByCreditCard(WalletEntity walletEntity) throws Exception;
}
