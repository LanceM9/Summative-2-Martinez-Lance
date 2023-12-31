package com.company.bookstore.controllers;

import com.company.bookstore.models.Author;
import com.company.bookstore.repositories.AuthorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AuthorController.class)
public class AuthorControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthorRepository authorRepository;

    private ObjectMapper mapper = new ObjectMapper();

    //Arrange the data
    Author author = new Author(1000, "Sarah", "Jennings", "123 Main Street", "San Francisco",
            "CA", "94014", "415-510-2311", "sarahjennings@na.com");
    @BeforeEach
    public void setUp() throws Exception{
        authorRepository.deleteAll();
    }

    @Test
    public void testPostAuthorShouldReturn201() throws Exception{
        String authorJson = mapper.writeValueAsString(author);

        mockMvc.perform(post("/authors")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(authorJson))
                .andDo(print())
                .andExpect(status().isCreated());
    }
    @Test
    public void testPutShouldReturnNoContent() throws Exception{
        String authorJson = mapper.writeValueAsString(author);

        mockMvc.perform(put("/authors")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(authorJson))
                .andDo(print())
                .andExpect(status().isNoContent());

    }
    @Test
    public void testGetAuthorByIdShouldReturn200() throws Exception{
        int id = author.getId();

        mockMvc.perform(get("/authors/{id}", id))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAllAuthorsShouldReturn200() throws Exception{
        mockMvc.perform(get("/authors"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    public void testDeleteShouldReturnNoContent() throws Exception{
        int id = author.getId();

        mockMvc.perform(delete("/authors/{id}", id))
                .andDo(print())
                .andExpect(status().isNoContent());

    }
}
