package com.bv.repositoryapp.service.kafka;

import com.bv.repositoryapp.service.ComputationListenerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ComputationResultListener {

    private final ComputationListenerService computationListenerService;

    @KafkaListener(id = "processing_id", topics = "${external.services.kafka.topic}")
    public void listen(String computationResult) throws JsonProcessingException {
        log.info("Received ComputationResult from Kafka: {}", computationResult);
        computationListenerService.processComputationResult(computationResult);
    }
}
