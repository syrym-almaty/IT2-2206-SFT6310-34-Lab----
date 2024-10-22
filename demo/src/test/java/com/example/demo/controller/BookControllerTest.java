package com.example.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCreateBook() throws Exception {
        String bookJson = "{\"title\": \"Effective Java\", \"author\": \"Joshua Bloch\", \"isbn\": \"9780134685991\", \"available\": true}";

        mockMvc.perform(post("/api/books")
                        .contentType(MediaType.APPLICATION_JSON)  // Указываем тип контента
                        .content(bookJson))  // Передаём JSON данные
                .andExpect(status().isOk())  // Проверяем, что статус 200 OK
                .andExpect(jsonPath("$.title").value("Effective Java"));  // Проверяем значение поля title
    }

    @Test
    public void testGetAllBooks() throws Exception {
        mockMvc.perform(get("/api/books"))
                .andExpect(status().isOk())  // Проверяем статус 200 OK
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));  // Проверяем, что тип контента JSON
    }
}
