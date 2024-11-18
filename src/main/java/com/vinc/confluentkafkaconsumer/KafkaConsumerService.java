package com.vinc.confluentkafkaconsumer;

import com.vinc.confluentkafkaconsumer.avro.AccountLedgerEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.common.TopicPartition;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaConsumerService {

    @KafkaListener(topics = "account_ledger", groupId = "orders_consumer_group")
    public void consume(
            AccountLedgerEvent event,
            Consumer<?, ?> consumer,
            Acknowledgment acknowledgment,
            AddressDto addressDto,
            AddressDto addressDto1) {

        log.info("AccountLedgerEvent: {}", event);
    }

    @KafkaListener(topics = "account_ledger", groupId = "orders_consumer_group")
    public void consumeFromOffset(AccountLedgerEvent event, Consumer<?, ?> consumer, Acknowledgment acknowledgment) {
        // Example: Set a specific offset for partition 0
        TopicPartition topicPartition = new TopicPartition("account_ledger", 5);
        long specificOffset = 0; // Replace with the desired offset

        AddressDto addressDto = AddressDto.builder()
                .street("Washington Blv. 129.")
                .state("Washington")
                .city("Washington DC")
                .zip("1111")
                .build();

        AddressDto addressDto1 = AddressDto.builder()
                .street("Washington Blv. 129.")
                .state("Washington")
                .city("Washington DC")
                .zip("1111")
                .build();

        // Seek to the specific offset
        consumer.seek(topicPartition, specificOffset);

        // Manually acknowledge the processing of this record
        acknowledgment.acknowledge();

        log.info("Consumed event: {}", event);
    }
}
