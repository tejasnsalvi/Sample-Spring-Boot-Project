package com.demigod.tutorial.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Properties;

@Configuration
@PropertySource("${spring.config.location}/APP-${MYENV}.properties")
public class DbConfig {

    @Value("${myDb1.datasource.myDb.url}")
    private String myDb1Url;

    @Value("${myDb1.datasource.myDb.driverclassname}")
    private String myDb1DriverClass;

    @Value("${myDb1.datasource.myDb.username}")
    private String myDb1Username;

    @Value("${myDb1.datasource.myDb.password}")
    private String myDb1Password;

    @Value("${myDb1.datasource.myDb.poolName}")
    private String myDb1PoolName;

    @Value("${myDb1.datasource.myDb.maxPoolSize}")
    private String myDb1MaxPool;

    @Value("${myDb1.datasource.myDb.minimumIdle}")
    private String myDb1MinIdle;

    @Value("${myDb1.datasource.myDb.connectionTimeout}")
    private String myDb1ConnectionTimeout;

    @Value("${myDb1.datasource.myDb.idleTimeout}")
    private String myDb1IdleTimeOut;
    

    public HikariDataSource myDb1DataSource() {
        Properties dsProps = new Properties();
        dsProps.put("url", myDb1Url);
        dsProps.put("user", myDb1Username);
        dsProps.put("password", myDb1Password);

        Properties configProps = new Properties();
        configProps.put("dataSourceClassName", myDb1DriverClass);
        configProps.put("poolName", myDb1PoolName);
        configProps.put("maximumPoolSize", myDb1MaxPool);
        configProps.put("minimumIdle", myDb1MinIdle);
        configProps.put("connectionTimeout", myDb1ConnectionTimeout);
        configProps.put("idleTimeout", myDb1IdleTimeOut);
        configProps.put("dataSourceProperties", dsProps);

        HikariConfig hc = new HikariConfig(configProps);
        HikariDataSource ds = new HikariDataSource(hc);

        return ds;
    }
    
    @Bean(name = "myDb1Read")
    @Lazy
    public JdbcTemplate portDbTemplate() {
        return new JdbcTemplate(myDb1DataSource());
    }
    

}
