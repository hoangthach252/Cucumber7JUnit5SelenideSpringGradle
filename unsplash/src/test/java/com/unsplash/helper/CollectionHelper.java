package com.unsplash.helper;

import com.google.gson.*;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CollectionHelper extends BaseAPI {

  public static JsonArray getCollectionList() {
    String url = APIEndpoints.GET_USER_COLLECTION;
    Map<String, String> headers = new HashMap<>();

    try {
      ResponseBody responseBody = sendGetRequest(url, headers, true);
      Gson gson = new Gson();
      return gson.fromJson(responseBody.string(), JsonArray.class);
    }
    catch (IOException | JsonSyntaxException | NullPointerException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static String getCollectionIdByName(String name) {
    JsonArray collectionList = CollectionHelper.getCollectionList();
    for (JsonElement collection : collectionList) {
      JsonObject collectionObject = collection.getAsJsonObject();
      if (collectionObject.get("title").getAsString().equals(name)) {
        return collectionObject.get("id").getAsString();
      }
    }
    return null;
  }

  public static boolean deleteCollectionById(String collectionId) {
    String url = APIEndpoints.DELETE_COLLECTION + collectionId;
    Map<String, String> headers = new HashMap<>();
    RequestBody formBody = new FormBody.Builder().add("id", collectionId).build();

    try {
      Response response = sendDeleteRequest(url, headers, formBody);
      if (Objects.requireNonNull(response).code() == 204) {
        return true;
      }
    }
    catch (JsonSyntaxException e) {
      e.printStackTrace();
    }
    return false;
  }

}