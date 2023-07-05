package com.zyd.blog.service;

import com.plexpt.chatgpt.ChatGPT;
import com.plexpt.chatgpt.util.Proxys;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.completion.chat.ChatMessageRole;
import com.theokanning.openai.service.OpenAiService;
import com.zyd.blog.BaseJunitTest;
import org.junit.jupiter.api.Test;

import java.net.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OpenAITest extends BaseJunitTest {

    @Test
    public void testChatGpt() {

        OpenAiService service = new OpenAiService("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");
        final List<ChatMessage> messages = new ArrayList<>();
        final ChatMessage systemMessage = new ChatMessage(ChatMessageRole.SYSTEM.value(), "写一段七言绝句诗，题目是：火锅！");
        messages.add(systemMessage);
        ChatCompletionRequest chatCompletionRequest = ChatCompletionRequest
                .builder()
                .model("gpt-3.5-turbo")
                .messages(messages)
                .n(1)
                .maxTokens(50)
                .logitBias(new HashMap<>())
                .build();

        service.streamChatCompletion(chatCompletionRequest)
                .doOnError(Throwable::printStackTrace)
                .blockingForEach(System.out::println);

        service.shutdownExecutor();
    }

    @Test
    public void testProxy() {
        //国内需要代理
        Proxy proxy = Proxys.http("43.136.171.117", 7890);
        //socks5 代理
        // Proxy proxy = Proxys.socks5("127.0.0.1", 1080);

        ChatGPT chatGPT = ChatGPT.builder()
                .apiKey("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")
                .proxy(proxy)
                .apiHost("https://api.openai.com/") //反向代理地址
                .build()
                .init();

        String res = chatGPT.chat("写一段七言绝句诗，题目是：火锅！");
        System.out.println(res);

    }
}
