package com.bazaratech.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bazaratech.starter.application.domain.model.Message;
import com.bazaratech.starter.application.domain.service.MessageService;
import com.bazaratech.starter.repository.MessageRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class MessageServiceTests {

    @Mock
	private MessageRepository messageRepository;

    private MessageService messageService;

    @BeforeEach
    public void setUp() {
        this.messageService = new MessageService(messageRepository);
    }


	@Test
	void testSavingMessage() {

        Message message = Message.builder()
        .message("Hello").build();

        when(messageRepository.save(any())).thenReturn(message);

		message = messageService.store(message);
		
		assertEquals(message.getMessage(),"Hello");

	}
    
}
