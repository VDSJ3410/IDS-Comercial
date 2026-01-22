package com.biblioteca.ms_consulta.config;

import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public Request.Options feignOptions() {
        return new Request.Options(5000, 5000); // connectTimeout, readTimeout (ms)
    }
}

