package com.unsplash.utils;

import ch.qos.logback.classic.Logger;
import io.cucumber.spring.ScenarioScope;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.unsplash.helper.CollectionHelper;

import java.util.ArrayList;
import java.util.List;

@ScenarioScope
@Component
public class DataStorage {

  private static final Logger logger = (Logger) LoggerFactory.getLogger(DataStorage.class);

  private List<String> collectionNames;

  public DataStorage() {
    this.collectionNames = new ArrayList<>();
  }

  private List<String> getCollectionNames() {
    return this.collectionNames;
  }

  public void setCollectionNames(String collection) {
    this.collectionNames.add(collection);
  }

  private void cleanUpCollection() {
    for (String collectionName : getCollectionNames()) {
      boolean status = CollectionHelper.deleteCollectionById(CollectionHelper.getCollectionIdByName(collectionName));
      if (!status) {
        logger.warn("!!!!!!!!!!! DELETE COLLECTION {} IS FAILED !!!!!!!!!!!", collectionName);
      }
      else {
        logger.info("!!!!!!!!!!! DELETE COLLECTION {} IS SUCCESSFUL !!!!!!!!!!!", collectionName);
      }
    }
  }

  public void cleanUpAll() {
    cleanUpCollection();
  }

}
