package com.jarmosz.advJava2019.ying_yang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Ying {
    private static final Logger logger = LoggerFactory.getLogger(Ying.class);

    /*

    Wstrzyknięcie Ying do Yang oraz Yang do Ying przez anotacje na konstruktorach spowoduje błąd aplikacji.
    Obie zależności cyklicznie wstrzykują siebie nawzajem.

    private Yang yang;

    @Autowired
    public Ying(Yang yang){
        this.yang = yang;
    }

    */

    /*
    Annotacje na polach. Rozwiązują problem z annotacjami na konstruktorach. Spring tworzy Beany Ying i Yang i ich zależności są wstrzywkiwane tylko wtedy kiedy jest to potrzebne.

    @Autowired
    private Yang yang;

    */

    /*
    Annotacje na setterach. Rozwiązują problem z annotacjami na konstruktorach. Spring tworzy Beany Ying i Yang i ich zależności są wstrzywkiwane tylko wtedy kiedy jest to potrzebne.

    private Yang yang;

    @Autowired
    public void setYang(Yang yang){
        this.yang = yang;
    }

    */

    /*
    Problem cyklicznego wstrzykiwania zależności nie występuje w przypadku wyboru dwóch różnych metod wstrzykiwania Ying do Yang i Yang do Ying.
     */

    @PostConstruct
    public void sayHello(){
        logger.info("Hello from Ying!");
    }
}
