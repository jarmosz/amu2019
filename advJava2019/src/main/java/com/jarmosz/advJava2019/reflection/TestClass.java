package com.jarmosz.advJava2019.reflection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TestClass {
    private static final Logger logger = LoggerFactory.getLogger(TestClass.class);

    private String name;

    private TestClass(){
        logger.info("Hello from private constructor!");
        this.name = "Sam";
    }

    private void sayName(){
        logger.info("Invoking private method! Name: {}", this.name);
    }



}
