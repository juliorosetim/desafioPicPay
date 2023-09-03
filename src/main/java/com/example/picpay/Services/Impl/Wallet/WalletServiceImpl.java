package com.example.picpay.Services.Impl.Wallet;

import com.example.picpay.Entity.wallet.WalletEntity;
import com.example.picpay.Repositories.Wallet.WalletRepository;
import com.example.picpay.Services.Wallet.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    WalletRepository walletRepository;
    @Override
    public List<WalletEntity> getAllWallet() throws Exception{
        try{
            return walletRepository.findAll();
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    @Override
    public WalletEntity walletSave(WalletEntity walletEntity) throws Exception {
        try {
            return walletRepository.save(walletEntity);
        }catch (Exception e){
            throw new Exception(e);
        }


    }

    @Override
    public WalletEntity findWalletByUserId(Long userId) throws Exception {
        try {
            return walletRepository.findWalletByUserId(userId);
        }catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Override
    public WalletEntity entryByCreditCard(WalletEntity walletEntity) throws Exception {
        try {
            walletRepository.save(walletEntity);
        }catch (Exception e){
            throw new Exception(e);
        }

        return null;
    }
}
