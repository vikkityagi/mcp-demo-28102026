package com.example.ai_assitant.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration 
public class AiConfig {

    @Bean
    public ChatClient chatClient(ChatClient.Builder builder) {
        return builder
                .defaultOptions(
                        OpenAiChatOptions.builder()
                                .model("openai/gpt-oss-20b")
                                .replayReasoningContent(false))
                .build();
    }
    
}
