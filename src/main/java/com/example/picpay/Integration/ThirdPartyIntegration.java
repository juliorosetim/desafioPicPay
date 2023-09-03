package com.example.picpay.Integration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@FeignClient(name = "authorization", url = "https://run.mocky.io/v3/8fafdd68-a090-496f-8c9a-3442cf30dae6")
public interface ThirdPartyIntegration {

    @GetMapping
    ResponseEntity<Map<String, String>> transactionAtuhorized();
}
