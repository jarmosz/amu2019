package com.jarmosz.advJava2019.di;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;

public interface Tool {

    Logger logger = LoggerFactory.getLogger(Tool.class);

    @PostConstruct
    default void sayHello(){
        logger.info("Hello from {}", this.getClass().getName() );
    }
}
