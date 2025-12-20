package com.ai.SpringAiDemo.controller;

import com.ai.SpringAiDemo.dto.ChatRequest;
import com.ai.SpringAiDemo.dto.ChatResponse;
import com.ai.SpringAiDemo.service.ChatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/message")
    public ResponseEntity<ChatResponse> sendMessage(@RequestBody ChatRequest chatRequest)
    {
        ChatResponse chatResponse = chatService.processMessage(chatRequest);
        return ResponseEntity.ok(chatResponse);
    }
}
