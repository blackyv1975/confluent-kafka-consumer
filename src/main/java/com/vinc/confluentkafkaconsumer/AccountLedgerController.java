package com.vinc.confluentkafkaconsumer;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account-ledger")
@RequiredArgsConstructor
public class AccountLedgerController {

    private final KafkaConsumerService kafkaConsumerService;

    @GetMapping
    public String sayHi() {
        return "Hello World";
    }

}