package com.jarmosz.advJava2019.di;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class Toolbox {

    private static final Logger logger = LoggerFactory.getLogger(Toolbox.class);

    @Autowired
    private List<Tool> tools;

    @PostConstruct
    @Bean
    public Tool createBeanFromAnonymousClass(){
        Tool Blade = new Tool() {
            @PostConstruct
            public void saidHello(){
                logger.info("Hello from anonymous class!");
            }
        };
        return Blade;
    }
    @PostConstruct
    public void sayHello(){
        logger.info("Toolbox class was created!");
    }

}
