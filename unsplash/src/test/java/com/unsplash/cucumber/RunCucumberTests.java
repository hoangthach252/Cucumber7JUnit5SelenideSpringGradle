package com.unsplash.cucumber;

import io.cucumber.junit.platform.engine.Constants;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasspathResource("features")
@IncludeEngines("cucumber")
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME, value = "com.unsplash.cucumber.steps")
@ConfigurationParameter(key = Constants.EXECUTION_DRY_RUN_PROPERTY_NAME, value = "false")
@ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME, value = "@regression and not @ignored")
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME,
    value = "pretty, summary, json:target/reports/cucumber-reports/cucumber.json,"
        + " io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm")
public class RunCucumberTests {
  // This class must be empty
  // Above Cucumber configuration parameters also can be set in junit-platform.properties or from command line.
  // priority order: ConfigurationParameter > command line System variables -D... > junit-platform.properties
}