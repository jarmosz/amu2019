package com.jarmosz.advJava2019.rest.Controllers;
import com.jarmosz.advJava2019.rest.Models.AuthorModel;
import com.jarmosz.advJava2019.rest.Services.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorsService authors;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public AuthorModel getAuthor(@Valid @PathVariable int id){
        return authors.getSingleAuthor(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public ArrayList<AuthorModel> getAuthors(){
        return authors.getAllAuthors();
    }

    @GetMapping("/age")
    @ResponseStatus(HttpStatus.FOUND)
        public ArrayList<AuthorModel> getAuthorsOlderThan(@Valid @RequestParam("moreThan") int age){
            return authors.getAllAuthorsOlderThan(age);
        }


    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void addAuthor(@Valid @RequestBody AuthorModel author ){
        authors.addSingleAuthor(author);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void changeAuthor(@Valid @RequestBody AuthorModel author){
        authors.changeSingleAuthor(author);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAuthor(@Valid int id){
        authors.deleteSingleAuthor(id);
    }

}
