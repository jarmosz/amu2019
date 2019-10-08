package com.jarmosz.advJava2019.intro;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import javax.annotation.PreDestroy;


@Component
public class GoodbyeWorld {
    private static final Logger logger = LoggerFactory.getLogger(GoodbyeWorld.class);

    @PreDestroy
    public void sayGoodbye(){
        logger.info("Goodbye!");
    }
}

