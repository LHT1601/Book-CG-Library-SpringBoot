package com.lht.Book_CGLibrary.controllers;

import com.lht.Book_CGLibrary.models.Book;
import com.lht.Book_CGLibrary.repository.BookRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public List<Book> findBookByName() {

        return bookRepository.findAll();
    }

    @GetMapping("/{bookId}")
    public Optional<Book> getBookDetails(@PathVariable(value = "bookId") String id) {

        return this.bookRepository.findById(id);
    }

    @PostMapping
    @RequestMapping("/")
    public Book addBook(@RequestBody Book book) {

        try {
            String bookId = UUID.randomUUID().toString();
            book.setId(bookId);
            bookRepository.saveAndFlush(book);
            return book;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new Book();
        }
    }

    @RequestMapping(value = "/{bookId}", method = RequestMethod.PUT)
    public Book updateBook(@PathVariable(value = "bookId") String id,
                           @RequestBody Book book) {

        try{
            Book existingBook = bookRepository.getReferenceById(id); //lấy tham chiếu theo id
            BeanUtils.copyProperties(book, existingBook, "id");
            return bookRepository.saveAndFlush(existingBook);
        } catch (Exception e) {
            return new Book();
        }
    }

    @RequestMapping(value = "/{bookId}", method = RequestMethod.DELETE)
//    public void removeBook(@PathVariable(value = "bookId") String id){
//        bookRepository.deleteById(id); }
    public void removeBook(@PathVariable(value = "bookId") String id) {

        Book book = bookRepository.getReferenceById(id);
        Optional opt = Optional.of(book);

        try {
            if (opt.isPresent()) {
                this.bookRepository.deleteById(id);
            }
        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    @RequestMapping(value = "/updateBooksStatus/{bookId}", method = RequestMethod.PUT)
    public void updateBooksStatus(@PathVariable(value = "bookId") String bookId){

        Book existingBook = bookRepository.getReferenceById(bookId);

        if (existingBook.getIsReady() == true) {
            existingBook.setIsReady(false);
        } else {
            existingBook.setIsReady(true);
        }

        bookRepository.saveAndFlush(existingBook);
    }
}
