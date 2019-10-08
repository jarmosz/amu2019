package com.jarmosz.advJava2019.di;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Primary
@Order(1)
@Profile("plumber")
public class Screvdriver implements Tool {

}
