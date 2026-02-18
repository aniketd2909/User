package org.example.uberend2end.configs;

import org.example.uberend2end.services.implementation.UserMcpService;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;


@Configuration
public class McpConfig {

    @Bean
    public ToolCallbackProvider myTools(UserMcpService userMcpService) {
        return MethodToolCallbackProvider.builder()
                .toolObjects(userMcpService)
                .build();
    }

}