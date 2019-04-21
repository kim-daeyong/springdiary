package my.example.spring.board.springboard.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

    @Configuration
    @PropertySource("classpath:application.properties")
    @ComponentScan(basePackages = { "my.example.spring.board.springboard.dao","my.example.spring.board.springboard.service" })
    @Import({DataSourceConfig.class})
    public class ApplicationConfig {

}
