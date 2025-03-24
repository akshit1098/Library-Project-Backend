package com.api.book.bootrestbook.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.bootrestbook.entities.Book;
import com.api.book.bootrestbook.services.BookService;

@RestController
public class BookController {

    // here we are creating object bookService using Autowired of Springboot
    @Autowired
    private BookService bookService;

    // get all books handler
    @GetMapping("/books")
    // since return type is book object hence the method should have return type as Book
    public ResponseEntity<List<Book>> getBooks(){ // return response entity and list of books
        List<Book> list = this.bookService.getAllBooks();
        if (list.size()<=0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(list);
    }

    // get single books handler
    @GetMapping("/books/{id}") // specifyng book id
    public ResponseEntity<Book> getBook(@PathVariable("id") int id){ // binding that particular id
        Book book = bookService.getBookById(id);
        if(book==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(book));
    }

    // post single books handler
    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book){ // request body return JSON
        Book b = null;
        try{
            System.out.println("---->I reached here first.....");
            b = this.bookService.addBook(book);
            System.out.println(book);
            return ResponseEntity.of(Optional.of(book));
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
//     @PostMapping("/books")
//     public ResponseEntity<Book> addBook(@RequestBody Book book) {
//     Book b = null;
//     try {
//         System.out.println("---->I reached here first.....");
//         b = this.bookService.addBook(book);
//         System.out.println(book);
//         return ResponseEntity.status(HttpStatus.CREATED).body(b); // Status 201 for created resource
//     } catch (Exception e) {
//         e.printStackTrace();
//         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//     }
// }


    // delete book handler

    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable("bookId") int bookId){
        try{
            this.bookService.deleteBook(bookId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        


    }


    // update book handler
    @PutMapping("/books/{bookId}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("bookId") int bookId){ //binding bookId through the request
        try{
            this.bookService.updateBook(book, bookId); // updating from the arguments of the function
            return ResponseEntity.ok().body(book);
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }


}
