package com.ias.project.calculatorapi.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class WebCorsConfiguration {

    public void corsAdd(CorsRegistry corsRegistry){
        String port="4200";
        corsRegistry.addMapping("/**").allowedOrigins("http://localhost:"+port).allowedMethods("*");
    }
}
