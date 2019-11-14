package com.jarmosz.advJava2019.rest.Controllers;

import com.jarmosz.advJava2019.rest.Models.BookModel;
import com.jarmosz.advJava2019.rest.Services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BooksService books;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public BookModel getBook(@Valid @PathVariable int id){
        return books.getSingleBook(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public ArrayList<BookModel> getBooks(){
        return books.getAllBooks();
    }

    @GetMapping("/title")
    @ResponseStatus(HttpStatus.FOUND)
    public ArrayList<BookModel> getBooksWithPhraseInTitle(@Valid @RequestParam("include") String phrase){
        return books.getAllBooksWithPhraseInTitle(phrase);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void addBook(@Valid @RequestBody BookModel book ){
        books.addSingleBook(book);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void changeBook(@Valid @RequestBody BookModel book){
        books.changeSingleBook(book);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBook(@Valid @PathVariable int id){
        books.deleteSingleBook(id);
    }
}
