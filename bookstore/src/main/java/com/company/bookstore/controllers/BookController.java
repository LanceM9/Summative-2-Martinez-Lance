package com.company.bookstore.controllers;

import com.company.bookstore.models.Book;
import com.company.bookstore.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/Books")
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/Books/{id}")
    public Book getBookById(@PathVariable int id) {

        Optional<Book> returnVal = bookRepository.findById(id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }
    // @GetMapping("/Books/{id}")
    @GetMapping("/books/author/{id}")
    public Book getBookByAuthorId(@PathVariable int author_id) {

        Optional<Book> returnVal = bookRepository.findById(author_id);
        if (returnVal.isPresent()  ) {
            return returnVal.get();
        } else {
            return null;
        }
    }

    @PostMapping("/Books")
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook(@RequestBody Book Book) {
        return bookRepository.save(Book);
    }

    @PutMapping("/Books")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBook(@RequestBody Book Book) {
        bookRepository.save(Book);
    }

    @DeleteMapping("/Books/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable int id) {
        bookRepository.deleteById(id);
    }
}
