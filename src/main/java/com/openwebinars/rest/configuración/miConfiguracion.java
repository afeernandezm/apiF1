package com.openwebinars.rest.configuración;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class miConfiguracion {
    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
