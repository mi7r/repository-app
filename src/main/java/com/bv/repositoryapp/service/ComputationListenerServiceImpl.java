package com.bv.repositoryapp.service;

import com.bv.repositoryapp.model.ComputationResult;
import com.bv.repositoryapp.model.entity.ComputationResultEntity;
import com.bv.repositoryapp.repository.ComputationResultRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ComputationListenerServiceImpl implements ComputationListenerService {

    private final ObjectMapper objectMapper;
    private final ComputationResultRepository computationResultRepository;

    @Override
    public void processComputationResult(final String computationResult) throws JsonProcessingException {
        ComputationResult result = objectMapper.readValue(computationResult, ComputationResult.class);

        computationResultRepository.save(ComputationResultEntity.builder()
            .freqWord(result.freqWord())
            .avgParagraphSize(result.avgParagraphSize())
            .avgParagraphProcessingTime(result.avgParagraphProcessingTime())
            .totalProcessingTime(result.totalProcessingTime())
            .build());

        log.info("ComputationResul saved in Database.");
    }
}
