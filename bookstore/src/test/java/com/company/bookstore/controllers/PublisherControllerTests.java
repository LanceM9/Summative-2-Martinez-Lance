package com.company.bookstore.controllers;

import com.company.bookstore.models.Book;
import com.company.bookstore.models.Publisher;
import com.company.bookstore.repositories.PublisherRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.print.attribute.standard.Media;
import java.util.HashSet;
import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PublisherController.class)
public class PublisherControllerTests {
    @MockBean
    PublisherRepository publisherRepository;

    @Autowired
    MockMvc mockMvc;

    ObjectMapper mapper = new ObjectMapper();

    Set<Book> books = new HashSet<>();

    Publisher publisher = new Publisher(117, books, "Pearson", "123 Pearson Street", "New York City",
            "New York", "10001", "2123388487", "pearson.publishing@pearson.com");

    @BeforeEach
    public void setUp() {
        publisherRepository.deleteAll();
    }

    // Testing add publisher
    @Test
    public void addShouldReturn201 () throws Exception {
        // Act
        String inputJson = mapper.writeValueAsString(publisher);

        // Assert
        mockMvc.perform(post("/publishers")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    // Testing get all publishers
    @Test
    public void getShouldReturn200 () throws Exception {
        // Act
        publisherRepository.save(publisher);

        // Assert
        mockMvc.perform(get("/publishers"))
                .andExpect(status().isOk());
    }

    // Testing get publisher by id
    @Test
    public void getByIdShouldReturn200 () throws Exception {
        // Act
        publisherRepository.save(publisher);

        // Assert
        mockMvc.perform(get("/publishers/{id}"))
                .andExpect(status().isOk());
    }

    // Testing update publisher
    @Test
    public void updateShouldReturn204 () throws Exception {
        // Act
        String inputJson = mapper.writeValueAsString(publisher);

        // Arrange
        mockMvc.perform(put("/publishers")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    // Testing delete publisher by id
    @Test
    public void deleteByIdShouldReturn204 () throws Exception {
        // Act
        publisherRepository.save(publisher);

        // Arrange
        mockMvc.perform(delete("/publishers/{id}"))
                .andExpect(status().isNoContent());
    }


}
