package com.deutsche.ironbank2020.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Evgeny Borisov
 */
@Service
public class CheckService {

    @Autowired
    @LoadBalanced
    private RestTemplate restTemplate;


    @Autowired
    private RestTemplate restTemplateWithoutMagic;

    @Autowired
    DiscoveryClient discoveryClient;



    @EventListener(ContextRefreshedEvent.class)
    public void check() {
        System.out.println();
    }


}
