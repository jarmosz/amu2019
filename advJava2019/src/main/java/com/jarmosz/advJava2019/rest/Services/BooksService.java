package com.jarmosz.advJava2019.rest.Services;

import com.jarmosz.advJava2019.rest.Models.BookModel;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Component
public class BooksService {
    private ArrayList<BookModel> books;

    public BooksService(){
        this.books = new ArrayList<BookModel>();
    }

    public BookModel getSingleBook(int id){
        for(BookModel author : this.books){
            if(author.getId() == id){
                return author;
            }
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Book not found"
        );
    }

    public ArrayList<BookModel> getAllBooks(){
        if(this.books != null){
            return this.books;
        }
        else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Books not found"
            );
        }
    }

    public ArrayList<BookModel> getAllBooksWithPhraseInTitle(String phrase){
        ArrayList<BookModel> filteredBooks = new ArrayList<BookModel>();
        for(BookModel book : books){
            Matcher m = Pattern.compile(String.format(".*%s.*", phrase)).matcher(book.getTitle());
                if (m.find()) {
                    filteredBooks.add(book);
                }
        }

        if(filteredBooks.size() > 0){
            return filteredBooks;
        }
        else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Books not found"
            );
        }

    }

    public void addSingleBook(BookModel bookToAdd){
        for(BookModel book : this.books){
            if(book.getId() == bookToAdd.getId()){
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Book with this ID already exist!"
                );
            }
        }
        this.books.add(bookToAdd);
    }

    public void changeSingleBook(BookModel newBook){
        for(BookModel book : this.books){
            if(book.getId() == newBook.getId()){
                book = newBook;
            }
        }
        throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Book with this ID doesn't exist!"
        );
    }

    public void deleteSingleBook(int id){
        if(!books.removeIf(next -> next.getId() == id)){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Book with this ID doesn't exist!"
            );
        }
    }
}
