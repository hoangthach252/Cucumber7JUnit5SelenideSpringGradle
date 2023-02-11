package com.unsplash.cucumber.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$;

@Component
public class MainPage {

  private final SelenideElement loginLink = $("nav a[href$='/login']");
  private final SelenideElement signUpLink = $(By.xpath("//nav//a[text()='Sign up']"));

  public void clickOnLoginLink() {
    loginLink.click();
  }

  public void clickJoinFreeLink() {
    signUpLink.click();
  }

}
