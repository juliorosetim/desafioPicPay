package com.example.picpay.Dto;

import java.math.BigDecimal;

public record PaymentDto(Long userFrom, Long userTo, BigDecimal value) {
}
