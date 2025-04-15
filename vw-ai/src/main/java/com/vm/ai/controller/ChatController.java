package com.vm.ai.controller;

import com.vm.ai.repository.ChatHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.AbstractChatMemoryAdvisor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@RestController
@RequestMapping("/ai")
public class ChatController {

    private final ChatClient chatClient;

    private final ChatHistoryRepository chatHistoryRepository;

    @RequestMapping(value = "/chat", produces = "text/html; charset=utf-8")
    public Flux<String> chat(String prompt, String chatId) {
//        1. 保存会话id,这里的chat类型可以考虑优化为枚举类型
        chatHistoryRepository.save("chat", chatId);

//        2. 请求模型
        return chatClient.prompt()
                .user(prompt)
                // 下面这个是保证了不同的聊天对话前端会生成不同的id，不同的对话都能实现各自的记忆而不会混乱
                .advisors(advisorSpec -> advisorSpec.param(AbstractChatMemoryAdvisor.CHAT_MEMORY_CONVERSATION_ID_KEY, chatId))
                //.call()  阻断式输出，也就是大模型全部生成完了再输出，如果要流式输出就用.stream()
                .stream()
                .content();
    }
}
