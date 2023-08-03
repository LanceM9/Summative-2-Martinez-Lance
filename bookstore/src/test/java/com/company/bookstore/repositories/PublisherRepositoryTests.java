package com.company.bookstore.repositories;

import com.company.bookstore.models.Book;
import com.company.bookstore.models.Publisher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class PublisherRepositoryTests {
    @Autowired
    PublisherRepository publisherRepository;

    Set<Book> books = new HashSet<>();

    Publisher publisher = new Publisher(117, books, "Pearson", "123 Pearson Street", "New York City",
            "NY", "10001", "2123388487", "pearson.publishing@pearson.com");

    @BeforeEach
    public void setUp() {
        publisherRepository.deleteAll();
    }

    // Testing add publisher
    @Test
    public void shouldAddPublisher () {
        // Act
        publisher = publisherRepository.save(publisher);

        // Assert
        Optional<Publisher> publisher1 = publisherRepository.findById(publisher.getId());
        assertEquals(publisher1.get(), publisher);
    }

    // Testing get all publishers
    @Test
    public void shouldGetAllPublishers () {
        // Act
        publisherRepository.save(publisher);

        // Assert
        List<Publisher> publisherList = publisherRepository.findAll();
        assertEquals(1, publisherList.size());
    }

    // Testing get publisher by id
    @Test
    public void shouldGetPublisherById() {
        // Act
        publisher = publisherRepository.save(publisher);
        int id = publisher.getId();

        // Assert
        Optional<Publisher> publisher1 = publisherRepository.findById(id);
        assertEquals(publisher1.get(), publisher);
    }

    // Testing update publisher
    @Test
    public void shouldUpdatePublisher() {
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
        // Act
        publisher = publisherRepository.save(publisher);

        // Assert
        Optional<Publisher> publisher1 = publisherRepository.findById(publisher.getId());



        publisherRepository.deleteById(publisher.getId());

        publisher1 = publisherRepository.findById(publisher.getId());

        assertFalse(publisherRepository.findById(publisher.getId()).isPresent());
    }
}
