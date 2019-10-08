package com.jarmosz.advJava2019.intro;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class HelloWorld {
    private static final Logger logger = LoggerFactory.getLogger(HelloWorld.class);

    @PostConstruct
    public void sayHello(){
        logger.info("Hello!");
    }
}
