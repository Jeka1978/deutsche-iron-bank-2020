package com.deutsche.ironbank2020;

import com.deutsche.ironbank2020.services.BankService;
import com.deutsche.ironbank2020.services.PredictionService;
import com.deutsche.ironbank2020.services.PredictionServiceImpl;
import com.ironbank.ironbankstarter2020.ConditionalOnProduction;
import com.ironbank.ironbankstarter2020.exceptions.ExceptionModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication


public class IronBank2020Application {




    @Bean
    @Primary
    public RestTemplate restTemplateExternal(RestTemplateBuilder builder){
        return builder.build();
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }



    public static void main(String[] args) {
        System.setProperty("java.awt.headless", "false");
        ConfigurableApplicationContext context = SpringApplication.run(IronBank2020Application.class, args);
        String s = context.getBean(RestTemplate.class)
                .postForObject("http://EXCEPTIONREISTRY/exceptionhandler/save", new ExceptionModel("a", "b"), String.class);
//        System.out.println("s = " + s);
//        System.out.println();
    }

}
