package com.vm.ai;

import org.junit.jupiter.api.Test;
import org.springframework.ai.openai.OpenAiEmbeddingModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
class VwAiApplicationTests {

    @Autowired
    private OpenAiEmbeddingModel embeddingModel;


    @Test
    void contextLoads() {
//        float[] vector = embeddingModel.embed("添砖Java");
//        System.out.println(Arrays.toString(vector));
    }

}
