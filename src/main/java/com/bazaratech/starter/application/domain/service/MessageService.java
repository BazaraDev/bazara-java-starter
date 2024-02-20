package com.bazaratech.starter.application.domain.service;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.bazaratech.starter.application.domain.model.Message;
import com.bazaratech.starter.microservices.bored.BoredServiceClient;
import com.bazaratech.starter.repository.MessageRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;

    private final BoredServiceClient boredServiceClient;

    public Message store(Message message) {

        return messageRepository.save(message);

    }

    public List<Message> getAllMessages() {

        return messageRepository.findAll();
    }

    public Message getRandomMessage() {
        return Message.builder()
            .uuid(UUID.randomUUID())
            .message(boredServiceClient.getRandomBoredActivity().getActivity())
            .build();
        
    }

}