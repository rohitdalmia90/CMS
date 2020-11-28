package com.cms.project.config;

import com.cms.project.filter.MyNewFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.FilterRegistration;

@Configuration
public class MyFilterConfig {

    @Bean
    public FilterRegistrationBean<MyNewFilter> registrationonBean() {
        FilterRegistrationBean<MyNewFilter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new MyNewFilter());
        filterFilterRegistrationBean.addUrlPatterns("/customers/*");

        return filterFilterRegistrationBean;

    }
}

