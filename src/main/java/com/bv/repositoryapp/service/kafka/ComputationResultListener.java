package com.bv.repositoryapp.service.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ComputationResultListener {

    @KafkaListener(id = "processing_id", topics = "${external.services.kafka.topic}")
    public void listen(String computationResultResponse) {
        log.info("Received ComputationResult from KAFKA: {}", computationResultResponse);
    }
}
