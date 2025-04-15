package com.vm.ai.repository;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class InMemoryChatHistoryRepository implements ChatHistoryRepository{

    // 临时存储 type : chatId的列表 一起键值对 使用map来存
    private final Map<String, List<String>> chatHistory = new HashMap<>();

    @Override
    public void save(String type, String chatId) {
//        if (!chatHistory.containsKey(type)){
//            chatHistory.put(type, new ArrayList<>());
//        }
//        List<String> chatIds = chatHistory.get(type);
//        上面的四行代码可以缩写为下面的一行，即判断传入的type存不存在，如果不存在，则创建一个新的list
        List<String> chatIds = chatHistory.computeIfAbsent(type, k -> new ArrayList<>());
        if (chatIds.contains(chatId)){
            return;
        }
        chatIds.add(chatId);
    }

    @Override
    public List<String> getChatIdList(String type) {
        List<String> chatIds = chatHistory.get(type);
        return chatIds != null ? chatIds : new ArrayList<>();
//        return chatHistory.getOrDefault(type, new ArrayList<>());
//        return chatHistory.getOrDefault(type, List.of());
//        下面这两种都是简化的写法，List.of()就是创一个新的空列表
    }
}
