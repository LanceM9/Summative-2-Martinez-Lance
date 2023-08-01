package com.company.bookstore.repositories;

import com.company.bookstore.models.Author;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuthorRepositoryTests {

    @Autowired
    AuthorRepository authorRepository;

    @BeforeEach
    public void setUp() throws Exception{
        authorRepository.deleteAll();
    }

    @BeforeAll
    public void initialize(){
        Author author = new Author();
        author.setFirstName("Peace");
        author.set

    }
    @Test
    public void shouldAllAuthor(){

    }



}
