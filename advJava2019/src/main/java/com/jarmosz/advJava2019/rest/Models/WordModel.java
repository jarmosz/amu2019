package com.jarmosz.advJava2019.rest.Models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WordModel {

    private String word;

    @Autowired
    public WordModel(){
        this.word = "";
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
