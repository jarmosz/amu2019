package com.jarmosz.advJava2019.singleton_prototypes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Scope("prototype")
public class PrototypeBean {
    private static final Logger logger = LoggerFactory.getLogger(PrototypeBean.class);

    @PostConstruct
    public void sayHello(){
        logger.info("Hello from PrototypeBean!");
    }
}
