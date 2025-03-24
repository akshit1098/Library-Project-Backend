package com.api.book.bootrestbook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;

@Component
public class BookService {
    // we can also use the data from the database

    //private static List<Book> list = new ArrayList<>();

    // static{
    //     list.add(new Book(12, "Java Complete reference", "XYZ"));
    //     list.add(new Book(36, "Head frst to Java", "ABC"));
    //     list.add(new Book(12963, "Thing in Java", "LMN"));
    // }

    @Autowired
    private BookRepository bookRepository;
    
    // get all books
    public List<Book> getAllBooks(){
        List<Book> list=(List<Book>) this.bookRepository.findAll(); // cast as list
        return list;
    }

    // get book by id
    public Book getBookById(int id){

        // you can use for-each too

        Book book = null;
        try{
            // book = list.stream().filter(e->e.getId()==id).findFirst().get();
            book=this.bookRepository.findById(id);
        } catch(Exception e){
            e.printStackTrace();
        }
        
        return book;
    }

    // method to add the book
    public Book addBook(Book b){
        //list.add(b);
        Book result=bookRepository.save(b);
        return result;
    }

    // method to delete book
    public void deleteBook(int bid){
        // Book book = null;
        // book = list.stream().filter(e->e.getId()==bid).findFirst().get();
        // System.out.println(book);

        // list = list.stream().filter(bookd-> bookd.getId()!=bid). // In this method, we are essentially updating the list 
        // collect(Collectors.toList());                          // with the books which do not match the id, hence skipping that book in new list


        bookRepository.deleteById(bid);

    }

    // update the book

    public void updateBook(Book book, int bookId){

        // list.stream().map(b->{
        //     if(b.getId()==bookId){
        //         b.setTitle(book.getTitle());
        //         b.setAuthor(book.getAuthor());
        //     }
        //     return b;
        // }).collect(Collectors.toList());

        book.setId(bookId);     // to ensure that correct book id is updated

        bookRepository.save(book);
    }


}
