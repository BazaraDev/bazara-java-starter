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
import com.bazaratech.starter.application.domain.service.MessageService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/messages")
public class MessageController {

    private final MessageService messageService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponse storeMessage(@RequestBody MessageRequest messageRequest) {

        Message message = Message.builder()
        .message(messageRequest.getMessage())
        .build();

        message = messageService.store(message);

        return MessageResponse.builder()
            .uuid(message.getUuid())
            .message(message.getMessage()).build();
    
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MessageResponse> getAllMessages() {
        
        return messageService.getAllMessages()
            .stream()
            .map(message -> MessageResponse.builder()
            .uuid(message.getUuid())
            .message(message.getMessage())
            .build())
            .toList();
    }
}
