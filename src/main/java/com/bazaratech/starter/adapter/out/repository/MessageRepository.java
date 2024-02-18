package com.bazaratech.starter.adapter.out.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

import com.bazaratech.starter.application.domain.model.Message;

public interface MessageRepository extends JpaRepository<Message, UUID> {
    
}
