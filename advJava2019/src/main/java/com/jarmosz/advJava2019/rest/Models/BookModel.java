package com.jarmosz.advJava2019.rest.Models;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;

@Component
@Scope("prototype")
@Valid
public class BookModel {
    @Min(1)
    private int id;
    @NotNull
    private String title;
    @Size(min=1)
    private ArrayList<AuthorModel> authors;
    @NotNull
    private int releaseYear;

    public BookModel(int id, String title, ArrayList<AuthorModel> authors, int releaseYear) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.releaseYear = releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<AuthorModel> getAuthors() {
        return authors;
    }

    public int getId() {
        return id;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(AuthorModel authorId) {
        this.authors.add(authorId);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
}
