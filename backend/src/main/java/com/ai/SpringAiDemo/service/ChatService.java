package com.ai.SpringAiDemo.service;

import com.ai.SpringAiDemo.dto.ChatRequest;
import com.ai.SpringAiDemo.dto.ChatResponse;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private final ChatClient chatClient;

    public ChatService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }


    public ChatResponse processMessage(ChatRequest chatRequest) {
        try {
            String content = chatClient.prompt()
                    .user(chatRequest.getMessage())
                    .call()
                    .content();
            return new ChatResponse(content);
        } catch (Exception e) {
           return new ChatResponse(e.getMessage());
        }
    }
}
