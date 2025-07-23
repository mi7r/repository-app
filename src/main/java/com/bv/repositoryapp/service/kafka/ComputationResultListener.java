package com.bv.repositoryapp.service.kafka;

import com.bv.repositoryapp.service.ComputationListenerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ComputationResultListener {

    private final ComputationListenerService computationListenerService;

    @Async("computationListenerTaskExecutor")
    @KafkaListener(
        id = "words_processed_id",
        topics = "${external.services.kafka.topic}",
        groupId = "word_processed_group",
        concurrency = "${external.services.kafka.concurrent-listeners-amount}"
    )
    public void listen(String computationResult) throws JsonProcessingException {
        log.info("Received ComputationResult from Kafka: {}", computationResult);
        computationListenerService.processComputationResult(computationResult);
    }
}
