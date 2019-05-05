package my.example.spring.diary.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

    @Configuration
    @PropertySource("classpath:application.properties")
    @ComponentScan(basePackages = { "my.example.spring.diary.dao","my.example.spring.diary.service" })
    @Import({DataSourceConfig.class})
    public class ApplicationConfig {

}
