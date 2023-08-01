package com.company.bookstore.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;

public class BookRepositoryTest {
    @Autowired
    com.company.bookstore.repositories.BookRepository BookRepository;

    @BeforeEach
    public void setUp() throws Exception {
        BookRepository.deleteAll();
    }
}
