package com.bazaratech.starter.microservices.producer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.bazaratech.starter.application.domain.model.Message;



@FeignClient( name = "producer-service", url="localhost:8080/api/producer")
public interface ProducerServiceClient {
    
    @GetMapping(value = "/random/message")
    Message getRandomMessage();


}
