package com.unsplash.cucumber.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

import org.springframework.stereotype.Component;

@Component
public class LoginPage {
  private final SelenideElement usernameField = $("input[name='user[email]']");
  private final SelenideElement passwordField = $("input[name='user[password]']");
  private final SelenideElement loginBtn = $("input[name='commit']");

  public void enterCredential(String usernameEmail, String pwd) {
    usernameField.setValue(usernameEmail);
    passwordField.setValue(pwd);
  }

  public void clickOnLoginButton() {
    loginBtn.click();
  }
}
