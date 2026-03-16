package com.example.agent;

import com.google.adk.agents.LlmAgent;
import com.google.adk.tools.GoogleSearchTool;
import com.google.adk.web.AdkWebServer;

public class LocalNews {
    public static void main(String[] args) {
        AdkWebServer.start(
                LlmAgent.builder()
                        .name("get-news")
                        .instruction("""
                                You are a news aggregator. When asked about news you search the internet for relevant news.
                                """)
                        .model("gemini-2.5-flash")
                        .tools(new GoogleSearchTool())
                        .build()
        );
    }
}
