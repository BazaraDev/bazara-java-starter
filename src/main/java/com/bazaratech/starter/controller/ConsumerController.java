package com.bazaratech.starter.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bazaratech.starter.application.domain.model.Message;
import com.bazaratech.starter.application.domain.service.ConsumerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/consumer")
public class ConsumerController {

    private final ConsumerService messageService;

    @GetMapping(value = "/random")
    @ResponseStatus(HttpStatus.OK)
    public Message getRandomMessage() {
        
        return messageService.getRandomMessage();
        
    }
}
