package com.company.bookstore.repositorys;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;

public class BookRepositoryTest {
    @Autowired
    BookRepository BookRepository;

    @BeforeEach
    public void setUp() throws Exception {
        BookRepository.deleteAll();
    }
}
