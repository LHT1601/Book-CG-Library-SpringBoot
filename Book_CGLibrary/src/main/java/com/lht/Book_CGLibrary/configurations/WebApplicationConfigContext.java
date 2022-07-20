package com.lht.Book_CGLibrary.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


@Configuration
@EnableWebMvc
@EnableTransactionManagement
public class WebApplicationConfigContext implements WebMvcConfigurer {

        @Bean
        public ViewResolver viewResolver() {
            InternalResourceViewResolver resource = new InternalResourceViewResolver();
            resource.setViewClass(JstlView.class);
            resource.setPrefix("WEB-INF/jsp/");
            resource.setSuffix(".jsp");
            return resource;
        }
}
