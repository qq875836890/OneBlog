package com.zyd.blog.util;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;
import org.junit.Test;

import java.time.Duration;
import java.util.Arrays;

public class OpenAITest {

    @Test
    public void testChatGPT() {
        String token = "123";
        // 构建openai api对象，由于处理时间比较长，建议设置一个合理的超时时间
        OpenAiService service = new OpenAiService(token, Duration.ofSeconds(60));
        CompletionRequest completionRequest = CompletionRequest.builder()
                .prompt("Human:如果有一辆车，车里面坐了小明小红小黄，请问车是谁的？\\n\\nAI:")
                .model("text-davinci-003")
                .temperature(0.9d)
                .maxTokens(150)
                .stop(Arrays.asList("Human:", "AI:"))
                .echo(true)
                .build();
        service.createCompletion(completionRequest).getChoices().forEach(System.out::println);
    }
}
