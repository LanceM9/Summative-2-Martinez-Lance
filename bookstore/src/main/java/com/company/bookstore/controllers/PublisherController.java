package com.company.bookstore.controllers;

import com.company.bookstore.models.Publisher;
import com.company.bookstore.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PublisherController {
    @Autowired
    PublisherRepository publisherRepository;

    @PostMapping("/publishers")
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher addPublisher (@RequestBody Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @GetMapping("/publishers")
    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    @GetMapping("/publishers/{id}")
    public Publisher getPublisher(@PathVariable int id) {
        Optional<Publisher> returnVal = publisherRepository.findById(id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }

    @PutMapping("/publishers")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePublisher(@RequestBody Publisher publisher) {
        publisherRepository.save(publisher);
    }

    @GetMapping("/publisher/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePublisher(@PathVariable int id){
        publisherRepository.deleteById(id);
    }
}
