package com.unsplash.helper;

import okhttp3.*;

import java.io.*;
import java.util.Map;

import com.unsplash.utils.PropertyUtils;

public class BaseAPI {
  private static final String ACCESS_TOKEN = PropertyUtils.getAccessToken();

  public static ResponseBody sendGetRequest(String url, Map<String, String> listHeader, boolean auth) {
    OkHttpClient httpClient = new OkHttpClient();
    Request.Builder requestBuilder = new Request.Builder();
    requestBuilder.url(url);
    if (!listHeader.isEmpty()) {
      listHeader.forEach(requestBuilder::addHeader);
    }
    if (auth) {
      requestBuilder.addHeader("Authorization", "Bearer " + ACCESS_TOKEN);
    }
    Request request = requestBuilder.method("GET", null).build();

    try (Response response = httpClient.newCall(request).execute()) {
      return response.peekBody(Long.MAX_VALUE);
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static Response sendPostRequest(String url, Map<String, String> listHeader, RequestBody requestBody,
      boolean auth) {
    OkHttpClient httpClient = new OkHttpClient();
    Request.Builder requestBuilder = new Request.Builder();
    listHeader.forEach(requestBuilder::addHeader);
    if (auth) {
      requestBuilder.addHeader("Authorization", "Bearer " + ACCESS_TOKEN);
    }
    requestBuilder.url(url).post(requestBody);
    Request request = requestBuilder.build();

    try (Response response = httpClient.newCall(request).execute()) {
      return response;
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static Response sendDeleteRequest(String url, Map<String, String> listHeader, RequestBody requestBody) {
    OkHttpClient httpClient = new OkHttpClient();
    Request.Builder requestBuilder = new Request.Builder();
    listHeader.forEach(requestBuilder::addHeader);
    requestBuilder.addHeader("Authorization", "Bearer " + ACCESS_TOKEN);
    requestBuilder.url(url).delete(requestBody);
    Request request = requestBuilder.build();

    try (Response response = httpClient.newCall(request).execute()) {
      return response;
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }
}