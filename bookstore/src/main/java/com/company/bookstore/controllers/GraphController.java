package com.company.bookstore.controllers;

import com.company.bookstore.models.Author;
import com.company.bookstore.models.Book;
import com.company.bookstore.models.Publisher;
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
    PublisherRepository publisherRepository;

    @QueryMapping
    public Publisher findPublisherById(@Argument Integer id) {
        Optional<Publisher> returnVal = publisherRepository.findById(id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }

    @SchemaMapping
    public Publisher publisher(Book book){
        Optional<Publisher>returnVal = publisherRepository.findById(book.getPublisherId());
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }


}
