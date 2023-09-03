package com.example.picpay.Controller.transactions;

import com.example.picpay.Dto.PaymentDto;
import com.example.picpay.Services.Transactions.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("transaction")
public class TransactionsController {

    @Autowired
    private TransactionsService transactionsService;

    @PostMapping
    public ResponseEntity makePayment(@RequestBody PaymentDto paymentDto) throws Exception{
        transactionsService.PayUser(paymentDto);

        return ResponseEntity.status(HttpStatus.OK).body("Pagamento realizado com sucesso");
    }
}
