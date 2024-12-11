package com.telefonia_vivas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TelefoniaVictorVivasApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(TelefoniaVictorVivasApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(TelefoniaVictorVivasApplication.class, args);
        LOGGER.info("¡Telfonia Victor Vivas iniciada correctamente! Accesible en: http://localhost:5050");
    }

}
