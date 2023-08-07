package com.company.bookstore.repositories;

import com.company.bookstore.models.Author;

import com.company.bookstore.models.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class AuthorRepositoryTests {

    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    PublisherRepository publisherRepository;
    Set<Book> books = new HashSet<>();

    @BeforeEach
    public void setUp() throws Exception{
        authorRepository.deleteAll();
    }

    @Test
    public void shouldAddAuthor(){
        Author author = new Author();
        author.setFirstName("Sarah");
        author.setLastName("Jennings");
        author.setStreet("Main St");
        author.setCity("San Jose");
        author.setState("CA");
        author.setPostalCode("94000");
        author.setPhone("415-000-9090");
        author.setEmail("sarahjennings@university.com");
        author = authorRepository.save(author);

        Optional<Author> author1 = authorRepository.findById(author.getId());
        assertEquals(author1.get(), author);
    }

    @Test
    public void shouldGetAllAuthors(){
        Author author = new Author();
        author.setFirstName("Sarah");
        author.setLastName("Jennings");
        author.setStreet("Main St");
        author.setCity("San Jose");
        author.setState("CA");
        author.setPostalCode("94000");
        author.setPhone("415-000-9090");
        author.setEmail("sarahjennings@university.com");

        Author author2 = new Author();
        author2.setFirstName("Moe");
        author2.setLastName("Jennings");
        author2.setStreet("Main St");
        author2.setCity("San Leandro");
        author2.setState("CA");
        author2.setPostalCode("94000");
        author2.setPhone("510-000-1235");
        author2.setEmail("moejennings@university.com");
        authorRepository.save(author);
        authorRepository.save(author2);

        List<Author> authorList = authorRepository.findAll();
        assertEquals(2, authorList.size());
    }


    @Test
    public void shouldGetAuthorById(){
        Author author = new Author();
        author.setFirstName("Sarah");
        author.setLastName("Jennings");
        author.setStreet("Main St");
        author.setCity("San Jose");
        author.setState("CA");
        author.setPostalCode("94000");
        author.setPhone("415-000-9090");
        author.setEmail("sarahjennings@university.com");

        author = authorRepository.save(author);
        int id = author.getId();

        Optional<Author> foundAuthor = authorRepository.findById(id);
        assertEquals(foundAuthor.get(), author);
    }

    @Test
    public void shouldUpdateAuthor(){
        Author author = new Author();
        author.setFirstName("Sarah");
        author.setLastName("Jennings");
        author.setStreet("Main St");
        author.setCity("San Jose");
        author.setState("CA");
        author.setPostalCode("94000");
        author.setPhone("415-000-9090");
        author.setEmail("sarahjennings@university.com");
        author = authorRepository.save(author);

        author.setStreet("Last St.");

        Optional<Author> author1 = authorRepository.findById(author.getId());
        assertNotEquals(author1.get(), author);
    }

    @Test
    public void shouldDeleteAuthor(){
        Author author = new Author();
        author.setFirstName("Sarah");
        author.setLastName("Jennings");
        author.setStreet("Main St");
        author.setCity("San Jose");
        author.setState("CA");
        author.setPostalCode("94000");
        author.setPhone("415-000-9090");
        author.setEmail("sarahjennings@university.com");

        author = authorRepository.save(author);
        authorRepository.delete(author);

        assertFalse(authorRepository.findById(author.getId()).isPresent());
    }


}

