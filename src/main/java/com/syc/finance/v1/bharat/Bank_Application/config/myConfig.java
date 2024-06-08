package com.syc.finance.v1.bharat.Bank_Application.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class myConfig {
    @Bean
    public ModelMapper mapper(){
        return new ModelMapper();
    }
}
