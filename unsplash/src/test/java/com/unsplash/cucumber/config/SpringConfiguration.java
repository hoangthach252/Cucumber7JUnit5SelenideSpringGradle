package com.unsplash.cucumber.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@ComponentScan({ "com.unsplash.cucumber.steps", "com.unsplash.cucumber.pages", "com.unsplash.utils",
    "com.unsplash.helper" })
@PropertySources({ @PropertySource("classpath:applicationtest.properties"), })
public class SpringConfiguration {
}
