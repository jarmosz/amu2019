package com.jarmosz.advJava2019.singleton_prototypes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ScopesShowcase {

//    Dzięki wywołaniu metody showcase wnioskujemy, że Bean który jest singletonem, jest tworzony tylko raz w Spring Context, a następnie jest do niego zwracana referencja.
//    W przypadku Beana o Scope ustawionym na prototype - za każdym razem gdy się do niego odwołujemy zwracana jest nowa instancja tej klasy w Spring Context.

    private static final Logger logger = LoggerFactory.getLogger(ScopesShowcase.class);
    private SingletonBean singletonBean;
    private PrototypeBean prototypeBean;
    private ApplicationContext context;

    @Autowired
    public ScopesShowcase(SingletonBean singletonBean, PrototypeBean prototypeBean, ApplicationContext context){
        this.singletonBean = singletonBean;
        this.prototypeBean = prototypeBean;
        this.context = context;
    }

    @PostConstruct
    private void showcase(){
        logger.info("Singleton: {}, Prototype: {}", this.singletonBean.hashCode(), this.prototypeBean.hashCode());
        showSingletonBeanInContext();
        showPrototypeBeanInContext();
    }

    @PostConstruct
    private void runShowcase(){
        showcase();
    }


    private void showSingletonBeanInContext(){
        logger.info("Singleton Bean from Context {}", context.getBean(SingletonBean.class).hashCode());

    }
    private void showPrototypeBeanInContext(){
        logger.info("Prototype Bean from Context {}", context.getBean(PrototypeBean.class).hashCode());

    }
}
