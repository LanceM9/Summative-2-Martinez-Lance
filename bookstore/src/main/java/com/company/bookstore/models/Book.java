package com.company.bookstore.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "book")
public class Book implements Serializable{

    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    private String isbn;

    private LocalDate publishDate;

    private Integer authorId;

    private String title;

    private Integer publisherId;

    private Integer price;

    public Book(Integer Id, String isbn, LocalDate publishDate, Integer authorId, String title, Integer publisherId, Integer price) {
        this.Id = Id;
        this.isbn = isbn;
        this.publishDate = publishDate;
        this.authorId = authorId;
        this.title = title;
        this.publisherId = publisherId;
        this.price = price;
    }

    public Book() {
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(Id, book.Id) && Objects.equals(isbn, book.isbn) && Objects.equals(publishDate, book.publishDate) && Objects.equals(authorId, book.authorId) && Objects.equals(title, book.title) && Objects.equals(publisherId, book.publisherId) && Objects.equals(price, book.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, isbn, publishDate, authorId, title, publisherId, price);
    }

    @Override
    public String toString() {
        return "Book{" +
                "Id=" + Id +
                ", isbn='" + isbn + '\'' +
                ", publishDate=" + publishDate +
                ", authorId=" + authorId +
                ", title='" + title + '\'' +
                ", publisherId=" + publisherId +
                ", price=" + price +
                '}';
    }

}