package com.company.bookstore.repositories;

import com.company.bookstore.models.Author;
import com.company.bookstore.models.Book;
import com.company.bookstore.models.Publisher;
import com.sun.source.tree.LambdaExpressionTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class BookRepositoryTests {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    PublisherRepository publisherRepository;

    Book book;
    Publisher publisher;

    Author author;

    BigDecimal bigDecimal = new BigDecimal("21.95");

    Publisher publisher2;
    Author author2;
    Set<Book> bookSet = new HashSet<>();
    @BeforeEach
    public void setUp() throws Exception {
        bookRepository.deleteAll();
        authorRepository.deleteAll();
        publisherRepository.deleteAll();



        publisher = new Publisher();
        author = new Author();


        author.setCity("apple");
        author.setEmail("asd@ad.com");
        author.setFirstName("First");
        author.setLastName("last");
        author.setPhone("46465645");
        author.setStreet("te");
        author.setState("zc");
        author.setPostalCode("123");


        publisher.setBooks(bookSet);
        publisher.setPhone("3516511");
        publisher.setName("aafsd");
        publisher.setCity("sadas");
        publisher.setEmail("asd");
        publisher.setPostalCode("213");
        publisher.setState("ge");
        publisher.setStreet("asda");

        publisher =  publisherRepository.save(publisher);
        author = authorRepository.save(author);

        publisher2 = new Publisher();
        author2 = new Author();


        //author.setBooks(bookList);
        author2.setCity("apple");
        author2.setEmail("asd@ad.com");
        author2.setFirstName("First");
        author2.setLastName("last");
        author2.setPhone("46465645");
        author2.setStreet("te");
        author2.setState("zc");
        author2.setPostalCode("123");


        publisher2.setBooks(bookSet);
        publisher2.setPhone("3516511");
        publisher2.setName("aafsd");
        publisher2.setCity("sadas");
        publisher2.setEmail("asd");
        publisher2.setPostalCode("213");
        publisher2.setState("ge");
        publisher2.setStreet("asda");

        publisher2 =  publisherRepository.save(publisher2);
        author2 = authorRepository.save(author2);

    }
    @Test
    public void shouldUpdateAll(){
        book = new Book();
        book.setAuthorId(author.getId());
        book.setPublisherId(publisher.getId());
        book.setIsbn("1235");
        book.setPrice(BigDecimal.valueOf(2.00));
        book.setTitle("Thery");
        book.setPublishDate(LocalDate.of(2018,8,19));

        book = bookRepository.save(book);

        List<Book> bookList = bookRepository.findAll();
        assertEquals(bookList.size(),1);
    }

    @Test
    public void addBook() throws Exception{
        book = new Book();
        book.setAuthorId(author.getId());
        book.setPublisherId(publisher.getId());
        book.setIsbn("1235");
        book.setPrice(BigDecimal.valueOf(2.00));
        book.setTitle("Thery");
        book.setPublishDate(LocalDate.of(2018,8,19));

        assertEquals( bookRepository.findAll().size(),0);
        book = bookRepository.save(book);



        Optional<Book> book1 = bookRepository.findById(book.getId());

        assertEquals( bookRepository.findAll().size(),1);


    }
    @Test
    public void shouldUpdateBookTest() throws Exception{

        Book book2 = new Book();
        book2.setAuthorId(author2.getId());
        book2.setPublisherId(publisher2.getId());
        book2.setIsbn("1235");
        book2.setPrice(bigDecimal);
        book2.setTitle("Thery");
        book2.setPublishDate(LocalDate.of(2018,8,19));
        bookRepository.save(book2);

        book2.setPublishDate(LocalDate.of(2000,8,13));
        bookRepository.save(book2);

        Optional<Book> book3 = bookRepository.findById(book2.getId());
        assertEquals(book3.get(),book2);
    }
    @Test
    public void shouldDeleteBookTest()throws Exception{
        Book book2 = new Book();
        book2.setAuthorId(author2.getId());
        book2.setPublisherId(publisher2.getId());
        book2.setIsbn("1235");
        book2.setPrice(bigDecimal);
        book2.setTitle("Thery");
        book2.setPublishDate(LocalDate.of(2018,8,19));
        bookRepository.save(book2);

        bookRepository.deleteById(book2.getId());

        Optional<Book> book3 = bookRepository.findById(book2.getId());
        assertFalse(book3.isPresent());
    }
    @Test
    public void shouldReturnBookById()throws Exception{
        book = new Book();
        book.setAuthorId(author.getId());
        book.setPublisherId(publisher.getId());
        book.setIsbn("1235");
        book.setPrice(bigDecimal);
        book.setTitle("Thery");
        book.setPublishDate(LocalDate.of(2018,8,19));
        book = bookRepository.save(book);

        Optional<Book> book1 = bookRepository.findById(book.getId());

        assertEquals(book1.get(),book);

    }
    @Test
    public void shouldReturnBookByAuthorId()throws Exception{
        book = new Book();
        book.setAuthorId(author.getId());
        book.setPublisherId(publisher.getId());
        book.setIsbn("1235");
        book.setPrice(bigDecimal);
        book.setTitle("Thery");
        book.setPublishDate(LocalDate.of(2018,8,19));
        book = bookRepository.save(book);

        Optional<Book> book1 = bookRepository.findByAuthorId(book.getAuthorId());

        assertEquals(book1.get(),book);
    }
}