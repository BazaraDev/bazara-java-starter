package com.bazaratech.demo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.io.IOUtils;
import org.apache.hc.client5.http.fluent.Request;
import org.apache.hc.core5.http.HttpResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.bazaratech.starter.application.domain.model.Message;
import com.bazaratech.starter.microservices.producer.ProducerServiceClient;
import com.fasterxml.jackson.databind.ObjectMapper;

import au.com.dius.pact.consumer.MockServer;
import au.com.dius.pact.consumer.dsl.PactBuilder;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTest;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.V4Pact;
import au.com.dius.pact.core.model.annotations.Pact;
import io.micrometer.common.util.StringUtils;

@ExtendWith(PactConsumerTestExt.class)
@SpringBootTest
public class ConsumerServiceTests {

    //@Autowired
    //private ProducerServiceClient producerServiceClient;


    @Pact(provider = "provider", consumer = "consumer")
    public V4Pact createRandomMessagePact(PactDslWithProvider builder) {
        return builder
            .given("messages exist")
            .uponReceiving("a request to Get a random message")
                .path("/api/producer/message/random")
                .method("GET")
            .willRespondWith()
                .status(200)
                .matchHeader("Content-Type", "application/json;charset=UTF-8")
                .body(new PactDslJsonBody()
                .uuid("uuid")
                .stringType("message"))
            .toPact(V4Pact.class);
    }

    @Test
    @PactTestFor(pactMethod = "createRandomMessagePact")
    public void verifyGetRandomMessage(MockServer mockServer) throws IOException {

        URL url = new URL(mockServer.getUrl() + "/api/producer/message/random");
        URLConnection con = url.openConnection();
        InputStream in = con.getInputStream();
        String encoding = con.getContentEncoding();
        encoding = encoding == null ? "UTF-8" : encoding;
        String body = IOUtils.toString(in, encoding);
        System.out.println(body);

        ObjectMapper objectMapper = new ObjectMapper();
        
        Message message = objectMapper.readValue(body, Message.class);

        assertTrue(StringUtils.isNotBlank(message.getMessage()), message.getMessage());
    }
    
}
