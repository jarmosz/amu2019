package com.jarmosz.advJava2019.rest.Controllers;

import com.jarmosz.advJava2019.rest.Models.WordModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/echo")
public class EchoController {

    @Autowired
    private WordModel wordModel;

    @GetMapping("/{text}")
    public String getTextFromUrl(@PathVariable String text){
        return text;
    }

    @GetMapping
    public String getTextFromParam(@RequestParam("word") String word){
        return word;
    }

    @PostMapping()
    public String sendTextFromRequestBody(@RequestBody String word){ return word;}


    @PostMapping("/1")
    public String sendJsonFromRequestBodyAsText(@RequestBody Map<String, String> body){
        return body.get("word");
    }

    @PostMapping("/2/{word}")
    public WordModel sendTextFromRequestBodyAsJson(@PathVariable String word){
        wordModel.setWord(word);
        return wordModel;
    }

}
