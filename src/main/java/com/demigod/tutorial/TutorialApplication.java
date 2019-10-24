package com.demigod.tutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
/**
 * @author TejasS
 */
@SpringBootApplication
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
@ComponentScan(basePackages = "com.demigod.tutorial")
@EnableScheduling
@EnableAsync
public class TutorialApplication {

    public static void main(String[] args) {
        SpringApplication.run(TutorialApplication.class, args);
    }

    
    /**
     * ## http://localhost:8686/myProject/swagger-ui.html#! link to open project in your browser
     * 
     *  Run Configurations 
     * *******            VM options:--Dspring.config.location=file:D:/myProject/props
     * Here put your propery file location
     * 
     * Enviornment Vairables:-
     *********            NW18ENV=DEV
     * 
     * This is reqd like you will be having three platfroms dev,stage,prod in your company when you work
     * accordingly you will have three property files 
     */

}
