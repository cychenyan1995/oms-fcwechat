package com.glsx.oms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class OMSTestBootStarter
{
    // spring默认已经注入了RestTemplateBuilder实例
    @Autowired
    private RestTemplateBuilder builder;
    
    @Bean
    public RestTemplate restTemplate()
    {
        return builder.build();
    }
    
    public static void main(String[] args)
    {
        SpringApplication.run(OMSTestBootStarter.class, args);
    }
    
}