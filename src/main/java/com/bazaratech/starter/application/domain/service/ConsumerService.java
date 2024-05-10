package com.bazaratech.starter.application.domain.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.bazaratech.starter.application.domain.model.Message;
import com.bazaratech.starter.microservices.producer.ProducerServiceClient;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ConsumerService {

    private final ProducerServiceClient producerServiceClient;


    public Message getRandomMessage() {
        return producerServiceClient.getRandomMessage();
        
    }

}