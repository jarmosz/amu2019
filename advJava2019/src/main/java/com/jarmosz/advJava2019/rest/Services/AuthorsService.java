package com.jarmosz.advJava2019.rest.Services;

import com.jarmosz.advJava2019.rest.Models.AuthorModel;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

@Component
public class AuthorsService {

    private ArrayList<AuthorModel> authors;

    public AuthorsService(){
        this.authors = new ArrayList<AuthorModel>();
        this.authors.add(new AuthorModel(1, "Stephen", "King", null, "USA", 78));
    }

    public AuthorModel getSingleAuthor(int id){
        for(AuthorModel author : this.authors){
            if(author.getId() == id){
                return author;
            }
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Author not found"
        );
    }

    public ArrayList<AuthorModel> getAllAuthors(){
        if(this.authors != null){
            return this.authors;
        }
        else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Authors not found"
            );
        }
    }

    public ArrayList<AuthorModel> getAllAuthorsOlderThan(int age){
        ArrayList<AuthorModel> olderAuthors = new ArrayList<AuthorModel>();

        for(AuthorModel author : this.authors) {
            if(author.getAge() > age){
                olderAuthors.add(author);
            }
        }

        if(olderAuthors.size() > 0){
            return olderAuthors;
        }
        else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Authors not found"
            );
        }

    }

    public void addSingleAuthor(AuthorModel authorToAdd){
        for(AuthorModel author : this.authors){
            if(author.getId() == authorToAdd.getId()){
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Author with this ID already exist!"
                );
            }
        }
        this.authors.add(authorToAdd);
    }

    public void changeSingleAuthor(AuthorModel newAuthor){
        for(AuthorModel author : this.authors){
            if(author.getId() == newAuthor.getId()){
                author = newAuthor;
            }
        }
        throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Author with this ID doesn't exist!"
        );
    }

    public void deleteSingleAuthor(int id){
        if(!authors.removeIf(next -> next.getId() == id)){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Author with this ID doesn't exist!"
            );
        }
    }
}
