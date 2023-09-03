package com.example.picpay.Controller.Wallet;

import com.example.picpay.Entity.wallet.WalletEntity;
import com.example.picpay.Services.Wallet.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/wallet")
public class WalletController {

    @Autowired
    WalletService walletService;

    @GetMapping
    public ResponseEntity<?> getAllWallets() throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(walletService.getAllWallet());
    }

    @PostMapping
    public ResponseEntity saveWallet(@RequestBody WalletEntity walletEntity) throws Exception{
        return ResponseEntity.status(HttpStatus.CREATED).body(walletService.walletSave(walletEntity));
    }

    @PutMapping("")
    public ResponseEntity addValueByCreditCard(@RequestBody WalletEntity walletEntity) throws Exception{
        return ResponseEntity.status(HttpStatus.CREATED).body(walletService.entryByCreditCard(walletEntity));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getWalletByUserId(@PathVariable Long userId) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(walletService.findWalletByUserId(userId));
    }
}
