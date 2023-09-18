package org.zerock.ex3.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {
    //컨트롤러 테스트해줌
    @Autowired
    private MockMvc mvc;

//    @DisplayName("hello 가 리턴된다")
//    @Test
//    public void hello() throws Exception {
//        String Hello = "hello";
//        mvc.perform(get("/hello")).andExpect(status().isOk())
//                .andExpect(content().string(hello));
//    }

    @DisplayName("hello 가 리턴된다")
    @Test
    public void helloDto() throws Exception {
        String name = "hello";
        int amount = 1000;
        mvc.perform(
                        get("/hello/dto")
                                .param("name", name)
                                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name))) //controller의 @RequestParam값 '$.~'으로 표기
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
