package com.unsplash.cucumber.steps;

import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;

import com.unsplash.cucumber.pages.HomePage;
import com.unsplash.cucumber.pages.LoginPage;
import com.unsplash.cucumber.pages.MainPage;
import com.unsplash.utils.Constants;
import com.unsplash.utils.PropertyUtils;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

  @Autowired
  private MainPage mainPage;
  @Autowired
  private LoginPage loginPage;
  @Autowired
  private HomePage homePage;

  @When("^the user is on the main page$")
  public void user_on_main_page() throws Throwable {
    open(PropertyUtils.getBaseUrl());
  }

  @When("^the user goes to Login Page$")
  public void go_to_login_page() throws Throwable {
    mainPage.clickOnLoginLink();
  }

  @When("^the user logs in \"(.*)\" credential$")
  public void go_to_login_page(String userName) throws Throwable {
    String[] userInfo = Constants.accountInfo.get(userName);
    loginPage.enterCredential(userInfo[2], userInfo[1]);
    loginPage.clickOnLoginButton();
  }

  @Then("^the user is redirected to Home Page$")
  public void redirected_to_home_page() throws Throwable {
    assertThat(homePage.isHomePageLoaded()).withFailMessage("Home Page is not loaded").isTrue();
  }
}
