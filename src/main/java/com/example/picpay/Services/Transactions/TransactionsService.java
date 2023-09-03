package com.example.picpay.Services.Transactions;

import com.example.picpay.Dto.PaymentDto;

public interface TransactionsService {

    void PayUser(PaymentDto paymentDto) throws Exception;
}
