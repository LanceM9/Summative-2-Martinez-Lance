package com.company.bookstore.controllers;

import com.company.bookstore.models.Author;
import com.company.bookstore.models.Book;
import com.company.bookstore.models.Publisher;
import com.company.bookstore.repositories.AuthorRepository;
import com.company.bookstore.repositories.BookRepository;
import com.company.bookstore.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class GraphController {
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    PublisherRepository publisherRepository;

    // do I need to schema map so that the author of the book is associated with the book?

    @Autowired
    BookRepository bookRepository;


    @QueryMapping
    public Author findAuthorById(@Argument Integer id){
        Optional<Author> returnVal = authorRepository.findById(id);
        if(returnVal.isPresent()){
            return returnVal.get();
        } else{
            return null;
        }
    }
    @QueryMapping
    public Publisher findPublisherById(@Argument Integer id) {
        Optional<Publisher> returnVal = publisherRepository.findById(id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }
    @QueryMapping
    public Book findBookById(@Argument Integer id){
        Optional<Book> returnVal = bookRepository.findById(id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }

    @SchemaMapping
    public Author author(Book book){
        Optional<Author> returnVal = authorRepository.findById(book.getAuthorId());
        if (returnVal.isPresent()) {
            return returnVal.get();
        }else {
            return null;

        }
    }
    /* One should return publisher and the other author
    paramerter is the book for both

    *
    * */

    @SchemaMapping
    public Publisher publisher(Book book){
        Optional<Publisher> returnVal = publisherRepository.findById(book.getAuthorId());
        if (returnVal.isPresent()) {
            return returnVal.get();
        }else {
            return null;
        }
    }
}
