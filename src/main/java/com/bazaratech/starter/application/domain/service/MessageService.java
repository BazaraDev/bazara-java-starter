package com.bazaratech.starter.application.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bazaratech.starter.application.domain.model.Message;
import com.bazaratech.starter.repository.MessageRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;

    public Message store(Message message) {

        return messageRepository.save(message);

    }

    public List<Message> getAllMessages() {

        return messageRepository.findAll();
    }

}