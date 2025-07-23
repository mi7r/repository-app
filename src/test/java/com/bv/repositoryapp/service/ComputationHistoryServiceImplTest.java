package com.bv.repositoryapp.service;

import com.bv.repositoryapp.converter.ComputationResultEntityToComputationResultConverter;
import com.bv.repositoryapp.error.ComputationResultNotFoundException;
import com.bv.repositoryapp.model.ComputationResult;
import com.bv.repositoryapp.model.entity.ComputationResultEntity;
import com.bv.repositoryapp.repository.ComputationResultRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ComputationHistoryServiceImplTest {

    @Mock
    private ComputationResultRepository computationResultRepository;

    @Mock
    private ComputationResultEntityToComputationResultConverter converter;

    @InjectMocks
    private ComputationHistoryServiceImpl computationHistoryServiceImpl;

    @Test
    void getComputationResultHistory_shouldReturnTwoRecords() {
        List<ComputationResultEntity> computationResultEntities = List.of(
            ComputationResultEntity.builder()
                .freqWord("check").avgParagraphSize(100).avgParagraphProcessingTime(100L).totalProcessingTime(200L).build(),
            ComputationResultEntity.builder()
                .freqWord("word").avgParagraphSize(100).avgParagraphProcessingTime(120L).totalProcessingTime(220L).build()
        );

        when(computationResultRepository.findTop10ByOrderByIdDesc()).thenReturn(computationResultEntities);

        List<ComputationResult> result = computationHistoryServiceImpl.getComputationResultHistory();

        assertEquals(2, result.size());
    }

    @Test
    void getComputationResultHistory_shouldThrowExceptionWhenNoRecordsFound() {
        when(computationResultRepository.findTop10ByOrderByIdDesc()).thenReturn(List.of());

        assertThrows(
            ComputationResultNotFoundException.class,
            () -> computationHistoryServiceImpl.getComputationResultHistory()
        );
    }
}