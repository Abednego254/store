package com.abednego.shop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // endpoints zako zote ziko hapa
                .allowedOrigins("http://localhost:5173") // react dev server
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // methods unazotumia
                .allowedHeaders("*")
                .allowCredentials(true); // kama utatumia cookies/sessions
    }
}

