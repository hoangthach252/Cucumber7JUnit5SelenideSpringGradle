package com.unsplash.cucumber.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

import org.springframework.stereotype.Component;

@Component
public class HomePage {

  private final SelenideElement searchBox = $("form[data-test='nav-bar-search-form-form'] input");

  public void enterSearch(String keyword) {
    searchBox.setValue(keyword);
    searchBox.pressEnter();
  }
}
