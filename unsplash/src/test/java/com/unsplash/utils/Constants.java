package com.unsplash.utils;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

public class Constants {

  public static final String DEFAULT_PASSWORD = "Test@123";

  public static Map<String, String[]> accountInfo = ImmutableMap.<String, String[]> builder()
      .put("zenautomator101", new String[] { "zenautomator101", "Test@123", "zenautoqa.client+automator101@gmail.com" })
      .build();

}