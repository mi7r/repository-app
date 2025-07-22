package com.bv.repositoryapp.converter;

import com.bv.repositoryapp.model.ComputationResult;
import com.bv.repositoryapp.model.entity.ComputationResultEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ComputationResultEntityToComputationResultConverter implements Converter<ComputationResultEntity, ComputationResult> {
    @Override
    public ComputationResult convert(final ComputationResultEntity source) {
        return ComputationResult.builder()
            .freqWord(source.getFreqWord())
            .avgParagraphSize(source.getAvgParagraphSize())
            .avgParagraphProcessingTime(source.getAvgParagraphProcessingTime())
            .totalProcessingTime(source.getTotalProcessingTime())
            .build();
    }
}
