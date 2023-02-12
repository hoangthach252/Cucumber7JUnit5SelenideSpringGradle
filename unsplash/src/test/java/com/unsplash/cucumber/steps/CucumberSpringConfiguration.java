package com.unsplash.cucumber.steps;

import org.springframework.boot.test.context.SpringBootTest;

import com.unsplash.cucumber.config.SpringConfiguration;

import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = SpringConfiguration.class)
public class CucumberSpringConfiguration {
}
