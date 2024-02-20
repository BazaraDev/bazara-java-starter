package com.bazaratech.starter.microservices.bored;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.bazaratech.starter.microservices.bored.domain.BoredActivity;

@FeignClient( name = "boredApi", url="www.boredapi.com/api")
public interface BoredServiceClient {
    
    @GetMapping(value = "/activity")
    BoredActivity getRandomBoredActivity();


}
