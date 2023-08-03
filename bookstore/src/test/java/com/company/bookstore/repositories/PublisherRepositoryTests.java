package com.company.bookstore.repositories;

import com.company.bookstore.models.Publisher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class PublisherRepositoryTests {
    @Autowired
    PublisherRepository publisherRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;


    @BeforeEach
    public void setUp() throws Exception{
        publisherRepository.deleteAll();
        bookRepository.deleteAll();
        authorRepository.deleteAll();
    }

    // Testing add publisher
    @Test
    public void shouldAddPublisher () {
        // Arrange
        Publisher publisher = new Publisher();
        publisher.setName("Pearson");
        publisher.setStreet("123 Pearson Street");
        publisher.setCity("New York City");
        publisher.setState("NY");
        publisher.setPostalCode("10001");
        publisher.setPhone("2123388487");
        publisher.setEmail("pearson.publishing@pearson.com");

        // Act
        publisher = publisherRepository.save(publisher);
        Optional<Publisher> publisher1 = publisherRepository.findById(publisher.getId());

        // Assert
        assertEquals(publisher1.get(), publisher);
    }

    // Testing get all publishers
    @Test
    public void shouldGetAllPublishers () {
        // Arrange
        Publisher publisher = new Publisher();
        publisher.setName("Pearson");
        publisher.setStreet("123 Pearson Street");
        publisher.setCity("New York City");
        publisher.setState("NY");
        publisher.setPostalCode("10001");
        publisher.setPhone("2123388487");
        publisher.setEmail("pearson.publishing@pearson.com");

        // Act
        publisherRepository.save(publisher);
        List<Publisher> publisherList = publisherRepository.findAll();

        // Assert
        assertEquals(publisherList.size(), 1);
    }

    // Testing get publisher by id
    @Test
    public void shouldGetPublisherById() {
        // Arrange
        Publisher publisher = new Publisher();
        publisher.setName("Pearson");
        publisher.setStreet("123 Pearson Street");
        publisher.setCity("New York City");
        publisher.setState("NY");
        publisher.setPostalCode("10001");
        publisher.setPhone("2123388487");
        publisher.setEmail("pearson.publishing@pearson.com");

        // Act
        publisher = publisherRepository.save(publisher);

        // Assert
        Optional<Publisher> publisher1 = publisherRepository.findById(publisher.getId());
        assertEquals(publisher1.get(), publisher);
    }

    // Testing update publisher
    @Test
    public void shouldUpdatePublisher() {
        // Arrange
        Publisher publisher = new Publisher();
        publisher.setName("Pearson");
        publisher.setStreet("123 Pearson Street");
        publisher.setCity("New York City");
        publisher.setState("NY");
        publisher.setPostalCode("10001");
        publisher.setPhone("2123388487");
        publisher.setEmail("pearson.publishing@pearson.com");

        // Act
        publisher = publisherRepository.save(publisher);

        publisher.setStreet("41st Ave");
        publisher.setPhone("3121207732");

        publisherRepository.save(publisher);

        // Assert
        Optional<Publisher> publisher1 = publisherRepository.findById(publisher.getId());
        assertEquals(publisher1.get(), publisher);
    }

    // Testing delete publisher by id
    @Test
    public void shouldDeletePublisher() {
        // Arrange
        Publisher publisher = new Publisher();
        publisher.setName("Pearson");
        publisher.setStreet("123 Pearson Street");
        publisher.setCity("New York City");
        publisher.setState("NY");
        publisher.setPostalCode("10001");
        publisher.setPhone("2123388487");
        publisher.setEmail("pearson.publishing@pearson.com");

        // Act
        publisher = publisherRepository.save(publisher);

        // Assert
        Optional<Publisher> publisher1 = publisherRepository.findById(publisher.getId());

        assertEquals(publisher1.get(), publisher);

        publisherRepository.deleteById(publisher.getId());

        publisher1 = publisherRepository.findById(publisher.getId());

        assertFalse(publisher1.isPresent());
    }
}
