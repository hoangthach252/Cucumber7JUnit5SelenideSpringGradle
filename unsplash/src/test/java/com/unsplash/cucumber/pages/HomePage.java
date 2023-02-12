package com.unsplash.cucumber.pages;

import com.codeborne.selenide.SelenideElement;
import com.unsplash.utils.CustomCondition;

import static com.codeborne.selenide.Selenide.$;

import org.springframework.stereotype.Component;

@Component
public class HomePage {

  private final SelenideElement searchBox = $("form[data-test='nav-bar-search-form-form'] input");
  private final SelenideElement profileIcon = $("#popover-avatar-loggedin-menu");

  public boolean isHomePageLoaded() {
    return profileIcon.isDisplayed();
  }

  public void enterSearch(String keyword) {
    searchBox.shouldBe(CustomCondition.clickable).setValue(keyword);
    searchBox.pressEnter();
  }
}
