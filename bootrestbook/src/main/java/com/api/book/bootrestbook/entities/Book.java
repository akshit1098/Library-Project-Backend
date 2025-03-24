package com.api.book.bootrestbook.entities;



import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="books")
public class Book {




    @Id // Primary Key
    @GeneratedValue(strategy = GenerationType.AUTO) // generate automated id for books created
    @Column(name = "book_id")
    private int id; // changed id to book_id in table
    private String title;

    // Cascade is done so that authorid is created automatically once the book is created, else it will result in error
    @OneToOne(cascade = jakarta.persistence.CascadeType.ALL) // this is one to one mapping (UNIDIRECTIONAL). So each book will have a unique author. We can get author from book but we cannot get book from author.
    
    @JsonManagedReference
    private Author author; // fetch the author for book so add json managed reference
    
    public Book(int id, String title, Author author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }
    public Book() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Author getAuthor() {
        return author;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }
    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", author=" + author + "]";
    }
    
}
