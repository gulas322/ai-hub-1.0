package com.vm.ai.entity.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.ollama.api.OllamaApi;

@NoArgsConstructor
@Data
public class MessageVO {
    private String role;
    private String content;

//    因为message中包含了四种类型，但是我们只需要user和assistant类型，所以需要做一下转换
    public MessageVO(Message message)
    {
        switch (message.getMessageType()){
            case USER:
                role = "user";
                break;
            case ASSISTANT:
                role = "assistant";
                break;
            default:
                role = "";
                break;
        }
        // 上面的switch将枚举类型role转化为字符串，下面这一步是获取 content
        this.content = message.getText();
    }
}
