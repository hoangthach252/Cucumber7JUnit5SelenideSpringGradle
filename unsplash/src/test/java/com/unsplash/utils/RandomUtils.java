package com.unsplash.utils;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RandomUtils {

  /**
   * Generate Random number with 4 digits length.
   */
  public static String getUniqueNumber() {
    SimpleDateFormat formatter = new SimpleDateFormat("ddMMMhhmmss");
    String strDate = formatter.format(new Date());
    SecureRandom random = new SecureRandom();
    return strDate.concat(new BigInteger(16, random).toString(1).toLowerCase());
  }

  public static String getTimeBasedUniqueNumber() {
    return String.valueOf(System.currentTimeMillis());
  }

  public static String getRandomEmail() {
    return "Automation" + RandomUtils.getUniqueNumber() + "@yopmail.com";
  }
}
