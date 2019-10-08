package com.jarmosz.advJava2019.di;

import org.springframework.context.annotation.Profile;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Profile("!plumber")
@Order(Ordered.LOWEST_PRECEDENCE)
public class Hammer implements Tool {

}
