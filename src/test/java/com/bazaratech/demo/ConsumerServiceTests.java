package com.bazaratech.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.bazaratech.starter.application.domain.service.ConsumerService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ConsumerServiceTests {

    private ConsumerService messageService;

    @BeforeEach
    public void setUp() {
       // this.messageService = new MessageService(messageRepository);
    }


	@Test
	void testSavingMessage() {
        /*
        Message message = Message.builder()
        .message("Hello").build();

        when(messageRepository.save(any())).thenReturn(message);

		message = messageService.store(message);
		
		assertEquals(message.getMessage(),"Hello");
        */
	}
    
}
