package com.example.ai_assitant.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.stereotype.Service;

@Service
public class AiService {

    private final ChatClient chatClient;
    private final ToolCallbackProvider mcpTools;

    public AiService(
            ChatClient chatClient,
            ToolCallbackProvider mcpTools) {

        this.chatClient = chatClient;
        this.mcpTools = mcpTools;
    }

    public String ask(String question) {
        return chatClient.prompt()
                .system("""
                            You are a tool-based assistant.

                        Rules:
                        1. Answer factual questions only using the
                           results returned by available tools.
                        2. Never answer using your own knowledge.
                        3. Never calculate or guess answers yourself.
                        4. If no suitable tool is available for the
                           question, respond exactly:
                           I don't have information about this.
                        5. If a tool fails or does not provide the
                           requested information, do not invent an answer.
                            """)
                .user(question)
                .tools(mcpTools)
                .call()
                .content();
    }
}