package com.unsplash.cucumber.steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.codeborne.selenide.WebDriverRunner;
import com.unsplash.utils.DataStorage;
import com.unsplash.utils.WebDriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class CucumberHooks {

  @SuppressWarnings("unused")
  private static Logger sLog = LoggerFactory.getLogger(CucumberHooks.class);

  @Autowired
  private DataStorage dataStorage;

  @BeforeAll
  public static void CucumberSetUpSuite() {
    sLog.info("Cucumber Suite SetUp");
  }

  @Before
  public void setUser(Scenario scenario) {
    WebDriverFactory.getWebDriverInstance();
  }

  @After
  public void logoutAndCLeanData(Scenario scenario) {

    if (scenario.isFailed()) {
      TakesScreenshot ts = (TakesScreenshot) WebDriverRunner.getWebDriver();
      byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
      scenario.attach(screenshot, "image/png", scenario.getName());
    }

    WebDriverFactory.closeWebDriverInstance();
    dataStorage.cleanUpAll();
  }

  @AfterAll
  public static void CucumberTearDownSuite() {
    sLog.info("Cucumber Suite Tear Down");
  }

}
