package com.company.bookstore.controllers;

import com.company.bookstore.models.Book;
import com.company.bookstore.repositories.BookRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDate;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
public class BookControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookRepository bookRepository;

    private ObjectMapper mapper = new ObjectMapper();

    private Book book1;

    private BigDecimal bigDecimal = new BigDecimal("2.22");

    @BeforeEach
    public void setUp(){
        bookRepository.deleteAll();

        book1 = new Book();

        book1.setId(1);
        book1.setAuthorId(1);
        book1.setPublisherId(1);
        book1.setIsbn("123465");
        book1.setPrice(bigDecimal);
        book1.setTitle("The story");
        //book1.setPublishDate(LocalDate.of(2018,8,19));
    }

    @Test
    public void testCreateShouldReturn200() throws Exception{

        Book book2 = new Book();

        book2.setId(2);
        book2.setAuthorId(2);
        book2.setPublisherId(2);
        book2.setIsbn("123365");
        book2.setPrice(bigDecimal);
        book2.setTitle("The book");
        // book2.setPublishDate(LocalDate.of(2018,8,19));

        String inputJson = mapper.writeValueAsString(book1);
        String outputJson = mapper.writeValueAsString(book2);

        mockMvc.perform(
                        post("/books")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void testUpdateShouldReturn200() throws Exception {
        book1.setId(3);

        String inputJson = mapper.writeValueAsString(book1);

        mockMvc.perform(
                        put("/books")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void testDeleteShouldReturn200() throws Exception{

        mockMvc.perform(delete("/books/1"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
    @Test
    public void testFindAllShouldReturn200() throws Exception{

        mockMvc.perform(get("/books"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    public void testFindByIdShouldReturn200() throws Exception {

        mockMvc.perform(get("/books/1"))
                .andExpect(status().isOk())
                .andDo(print());

    }
    @Test
    public void testFindBookByAuthorIdShouldReturn200() throws Exception {

        mockMvc.perform(get("/books/author/1"))
                .andExpect(status().isOk())
                .andDo(print());

    }
}
