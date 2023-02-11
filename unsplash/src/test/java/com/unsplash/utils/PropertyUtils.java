package com.unsplash.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtils {
  String result = "";
  InputStream inputStream;

  public static String getPropString(String propTerm) {
    return instance().getEnvPropertyValue(propTerm);
  }

  public static String getPropString(String propTerm, String fromPropertyFile) {
    return instance().getPropertyValueFromSpecifiedFile(propTerm, fromPropertyFile);
  }

  public static Boolean getPropBoolean(String propTerm) {
    return Boolean.parseBoolean(instance().getEnvPropertyValue(propTerm));
  }

  public static Boolean getPropBoolean(String propTerm, String fromPropertyFile) {
    return Boolean.parseBoolean(instance().getPropertyValueFromSpecifiedFile(propTerm, fromPropertyFile));
  }

  public static Integer getPropInteger(String propTerm) {
    return Integer.parseInt(instance().getEnvPropertyValue(propTerm));
  }

  public static Integer getPropInteger(String propTerm, String fromPropertyFile) {
    return Integer.parseInt(instance().getPropertyValueFromSpecifiedFile(propTerm, fromPropertyFile));
  }

  private static PropertyUtils instance() {
    return new PropertyUtils();
  }

  private String getPropertyValueFromSpecifiedFile(String propTerm, String propFileName) {
    return getPropertyValueFromFile(propTerm, propFileName);
  }

  private String getEnvPropertyValue(String propTerm) {
    String propertyFileName = "env.properties";
    return getPropertyValueFromFile(propTerm, propertyFileName);
  }

  private String getPropertyValueFromFile(String propTerm, String propFile) {
    try {
      Properties property = new Properties();

      inputStream = getClass().getClassLoader().getResourceAsStream(propFile);

      if (inputStream != null) {
        property.load(inputStream);
      }
      else {
        throw new FileNotFoundException("Property file '" + propFile + "' not found in the classpath");
      }

      result = property.getProperty(propTerm);

    }
    catch (Exception e) {
      System.out.println("Exception: " + e);
    }
    finally {
      try {
        inputStream.close();
      }
      catch (IOException e) {
        e.printStackTrace();
      }
    }
    return result;
  }

  public static String getBaseUrl() {
    return PropertyUtils.getPropString("baseUrl", "environment.properties");
  }

  public static String getApiBaseUrl() {
    return PropertyUtils.getPropString("apiBaseUrl", "environment.properties");
  }

  public static String getUserProfile() {
    return PropertyUtils.getPropString("userProfile", "environment.properties");
  }

  public static String getAccessToken() {
    return PropertyUtils.getPropString("accessToken", "environment.properties");
  }
}
