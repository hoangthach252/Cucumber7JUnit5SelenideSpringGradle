package com.unsplash.helper;

import com.unsplash.utils.PropertyUtils;

public class APIEndpoints {

  public static String GET_USER_COLLECTION = PropertyUtils.getApiBaseUrl() + "users/" + PropertyUtils.getUserProfile()
      + "/collections";
  public static String DELETE_COLLECTION = PropertyUtils.getApiBaseUrl() + "collections/";
}
