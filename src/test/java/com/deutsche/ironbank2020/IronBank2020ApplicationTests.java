package com.deutsche.ironbank2020;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class IronBank2020ApplicationTests {

    @Value("${server.port}")
    private String port;

    @Autowired
    private ApplicationContext context;


    @Test
    void contextLoads() {

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> entity = restTemplate.getForEntity("http://localhost:" + port + "/bank/loan?name=stark&amount=10", String.class);
//        String body = restTemplate.getForObject("http://localhost:8088/bank/loan?name=stark&amount=10", String.class);
        Assert.assertTrue(entity.getBody().toLowerCase().contains("rejected"));
    }

}
