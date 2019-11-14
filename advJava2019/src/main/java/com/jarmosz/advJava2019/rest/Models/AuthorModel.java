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
public class AuthorModel {
    @Min(1)
    private int id;
    @NotNull
    private String name;
    @NotNull
    private String surname;
    @Size(min=1)
    private ArrayList<BookModel> books;
    @NotNull
    private String nationality;
    @NotNull
    private int age;

    public AuthorModel(int id, String name, String surname, ArrayList<BookModel> books, String nationality, int age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.books = new ArrayList<BookModel>();
        this.nationality = nationality;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getId() {
        return id;
    }

    public ArrayList<BookModel> getBooks() {
        return books;
    }

    public String getNationality() {
        return nationality;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBooks(ArrayList<BookModel> books) {
        this.books = books;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
