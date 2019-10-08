package com.jarmosz.advJava2019.ying_yang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Yang {
    private static final Logger logger = LoggerFactory.getLogger(Yang.class);

    /*

     Wstrzyknięcie Ying do Yang oraz Yang do Ying przez anotacje na konstruktorze spowoduje błąd aplikacji.
     Obie zależności cyklicznie wstrzykują siebie nawzajem.

     private Ying ying;

     @Autowired
     public Yang(Ying ying) {
         this.ying = ying;
     }

    */

    /*
    Annotacje na polach. Rozwiązują problem z annotacjami na konstruktorach. Spring tworzy Beany Ying i Yang i ich zależności są wstrzywkiwane tylko wtedy kiedy jest to potrzebne.

    @Autowired
    private Ying ying;

    */


    /*
    Annotacje na setterach. Rozwiązują problem z annotacjami na konstruktorach. Spring tworzy Beany Ying i Yang i ich zależności są wstrzywkiwane tylko wtedy kiedy jest to potrzebne.

    private Ying ying;
    @Autowired
    public void setYing(Ying ying){
        this.ying = ying;
    }

    */

     /*
    Problem cyklicznego wstrzykiwania zależności nie występuje w przypadku wyboru dwóch różnych metod wstrzykiwania Ying do Yang i Yang do Ying.
     */


    @PostConstruct
    public void sayHello(){
        logger.info("Hello from Yang!");
    }

}
