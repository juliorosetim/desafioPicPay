package com.example.picpay.Services.Impl.Transactions;

import com.example.picpay.Dto.PaymentDto;
import com.example.picpay.Entity.wallet.WalletEntity;
import com.example.picpay.Integration.ThirdPartyIntegration;
import com.example.picpay.Repositories.Users.UsersRepository;
import com.example.picpay.Repositories.Wallet.WalletRepository;
import com.example.picpay.Services.Transactions.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TransactionsServiceImpl implements TransactionsService {

    private final String MERCHANT = "MERCHANT";

    private final String AUTORIZADO = "Autorizado";
    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private ThirdPartyIntegration thirdPartyIntegration;

    @Override
    public void PayUser(PaymentDto paymentDto) throws Exception {
        try{
            WalletEntity walletTo = walletRepository.findWalletByUserId(paymentDto.userTo());

            validations(paymentDto, walletTo);

            WalletEntity walletFrom = walletRepository.findWalletByUserId(paymentDto.userFrom());

            walletTo.setBalance( walletTo.getBalance().subtract(paymentDto.value()));

            walletFrom.setBalance( walletFrom.getBalance().add(paymentDto.value()));

            walletRepository.save(walletTo);

            walletRepository.save(walletFrom);
        }catch (Exception e) {
            throw new Exception(e);
        }
    }

    private void validations(PaymentDto paymentDto, WalletEntity walletEntity) throws Exception {
        if (paymentDto.value().compareTo(walletEntity.getBalance()) > 0) {
            throw new Exception("Saldo insuficiente");
        }

        if (walletEntity.getUser().getUserType().name().equals(MERCHANT)) {
            throw new Exception("Lojistas não podem realizar pagamentos!");
        }

        ResponseEntity<Map<String, String>> authorizationResponse = thirdPartyIntegration.transactionAtuhorized();

        if (authorizationResponse.getStatusCode() == HttpStatus.OK){
          Map<String, String> responseMessage = authorizationResponse.getBody();

            if (responseMessage != null &&
                    responseMessage.containsKey("message") &&
                    !responseMessage.get("message").equals(AUTORIZADO)){
                throw new Exception("Transação não autorizada!");
            }
        }

    }
}
