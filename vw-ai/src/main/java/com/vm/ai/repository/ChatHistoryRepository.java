package com.vm.ai.repository;

import java.util.List;

public interface ChatHistoryRepository {

    /**
     * 保存聊天记录
     * @param type 业务类型 如chat Service pdf服务等
     * @param chatId
     */
    void save(String type, String chatId);

    /**
     * 获取聊天记录
     * @param type 业务类型 如chat Service pdf服务等
     * @return 传入业务类型，返回会话id的列表
     */
    List<String> getChatIdList(String type);


}
