package com.telefonia_vivas.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class MessageConfig {

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames(

                "classpath:ValidationMessagesRegion",
                "classpath:ValidationMessagesPersona",
                "classpath:ValidationMessagesDireccion",
                "classpath:ValidationMessagesComuna"
        );
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}
