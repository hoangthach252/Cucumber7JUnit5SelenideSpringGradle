package com.unsplash.cucumber.pages;

import com.codeborne.selenide.SelenideElement;
import com.unsplash.utils.CustomCondition;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$;

@Component
public class SearchResultPage {

  private final SelenideElement photoGrid = $("div[data-test='masonry-grid-count-three']");
  private final SelenideElement firstPhoto = photoGrid.findAll("figure").first();
  private final SelenideElement addCollectionBtn = photoGrid.find("button[title='Add to collection']");
  private final SelenideElement createNewCollectionBtn = $(By.xpath("//button[text()='Create a new collection']"));

  public void addFirstPicToCollection() {
    firstPhoto.hover();
    addCollectionBtn.shouldBe(CustomCondition.clickable).click();
  }

  public void createNewCollection() {
    createNewCollectionBtn.shouldBe(CustomCondition.clickable).click();
  }

}
