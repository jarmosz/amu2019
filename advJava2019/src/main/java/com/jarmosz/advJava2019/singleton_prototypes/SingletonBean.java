package com.jarmosz.advJava2019.singleton_prototypes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

// Nie jest potrzebna dodatkowa annotacja - defaultowo Bean ma ustawiony scope na Singleton.

@Component
public class SingletonBean {
    private static final Logger logger = LoggerFactory.getLogger(SingletonBean.class);

    @PostConstruct
    public void sayHello(){
        logger.info("Hello from SingletonBean!");
    }
}
