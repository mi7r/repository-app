package com.bv.repositoryapp.api.controller;

import com.bv.repositoryapp.model.ComputationResult;
import com.bv.repositoryapp.service.ComputationHistoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ComputationHistoryControllerTest {

    @Mock
    private ComputationHistoryService computationHistoryService;

    @InjectMocks
    private ComputationHistoryController computationHistoryController;

    @Test
    void getComputationHistoryEndpoint_shouldReturnComputationResultListAndStatusOK() {
        final List<ComputationResult> fakeComputationResultList = List.of(
            ComputationResult.builder()
                .freqWord("check").avgParagraphSize(100).avgParagraphProcessingTime(100L).totalProcessingTime(300L).build(),
            ComputationResult.builder()
                .freqWord("word").avgParagraphSize(200).avgParagraphProcessingTime(200L).totalProcessingTime(600L).build()
        );

        when(computationHistoryService.getComputationResultHistory()).thenReturn(fakeComputationResultList);

        ResponseEntity<List<ComputationResult>> result = computationHistoryController.getComputationHistory();

        verify(computationHistoryService, times(1)).getComputationResultHistory();
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);

        List<ComputationResult> body = result.getBody();
        assertThat(body).isEqualTo(fakeComputationResultList);
    }

}