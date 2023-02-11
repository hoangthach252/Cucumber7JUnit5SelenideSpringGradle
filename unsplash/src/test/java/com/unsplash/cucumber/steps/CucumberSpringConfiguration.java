package com.unsplash.cucumber.steps;

import org.springframework.test.context.ContextConfiguration;

import com.unsplash.cucumber.config.SpringConfiguration;

import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = SpringConfiguration.class)
public class CucumberSpringConfiguration {
}
