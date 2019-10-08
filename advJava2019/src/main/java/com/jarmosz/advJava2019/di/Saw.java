package com.jarmosz.advJava2019.di;

import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Profile("electrician")
@Order(2)
public class Saw implements Tool {
}
