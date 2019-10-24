package com.demigod.tutorial.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("${spring.config.location}/APP-${MYENV}.properties")
public class GeneralConfig {

    @Value("${filePath}")
    private String filePath;

    @Bean(name = "filePath")
    @Lazy
    public String getFilePath() {
        return filePath;
    }
}
