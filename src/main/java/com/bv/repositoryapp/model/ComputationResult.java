package com.bv.repositoryapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record ComputationResult(
    @JsonProperty("freq_word") String freqWord,
    @JsonProperty("avg_paragraph_size") Integer avgParagraphSize,
    @JsonProperty("avg_paragraph_processing_time") Long avgParagraphProcessingTime,
    @JsonProperty("total_processing_time") Long totalProcessingTime
) {
}
