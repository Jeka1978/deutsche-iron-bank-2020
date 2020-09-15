package com.deutsche.ironbank2020;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.io.support.SpringFactoriesLoader;

@SpringBootApplication
public class IronBank2020Application {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(IronBank2020Application.class, args);
    }

}
