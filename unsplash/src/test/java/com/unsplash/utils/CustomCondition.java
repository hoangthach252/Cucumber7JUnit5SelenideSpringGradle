package com.unsplash.utils;

import com.codeborne.selenide.Condition;

public class CustomCondition {

  public static Condition clickable = Condition.and("clickable", Condition.enabled, Condition.visible);
}
