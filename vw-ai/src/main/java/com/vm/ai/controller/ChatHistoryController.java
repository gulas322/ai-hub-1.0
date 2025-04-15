package com.vm.ai.controller;

import com.vm.ai.entity.vo.MessageVO;
import com.vm.ai.repository.ChatHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.messages.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/ai/history")
public class ChatHistoryController {
    private final ChatHistoryRepository chatHistoryRepository;

//    public ChatHistoryController(ChatHistoryRepository chatHistoryRepository)
//    {
//        this.chatHistoryRepository = chatHistoryRepository;
//    }  这个的意思和@RequiredArgsConstructor一样，都是用set方法注入

    private final ChatMemory chatMemory;

    @GetMapping("/{type}")
    public List<String> getChatIdList(@PathVariable("type") String type)
    {
        return chatHistoryRepository.getChatIdList(type);
    }

    @GetMapping("/{type}/{chatId}")
    public List<MessageVO> getChatHistory(@PathVariable("type") String type, @PathVariable("chatId") String chatId){
        List<Message> messages = chatMemory.get(chatId, Integer.MAX_VALUE);
        if (messages == null){
            return List.of();
        }
        return messages.stream().map(m -> new MessageVO(m)).toList();
    }
}
