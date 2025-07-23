package com.bv.repositoryapp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.task.ThreadPoolTaskExecutorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Executor;

@EnableAsync
@Configuration
public class AcyncConfig {

    @Value("${external.services.kafka.processing-threads-amount}")
    private int numberOfConcurrentThreads;

    @Bean
    public Executor computationListenerTaskExecutor(ThreadPoolTaskExecutorBuilder taskExecutorBuilder) {
        return taskExecutorBuilder
            .threadNamePrefix("task-executor-")
            .corePoolSize(numberOfConcurrentThreads)
            .maxPoolSize(numberOfConcurrentThreads)
            .build();
    }
}
