package com.company.bookstore.controllers;

import com.company.bookstore.models.Author;
import com.company.bookstore.models.Publisher;
import com.company.bookstore.repositories.AuthorRepository;
import com.company.bookstore.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
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
}
