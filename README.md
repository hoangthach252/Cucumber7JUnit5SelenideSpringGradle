# Automation Framework using Cucumber JVM7 + JUnit5 + Selenide + Gradle + Allure + logback

A sample BDD Automation framework using Cucumber7, JUnit 5, Selenide, Gradle, Allure, logback.

Support running tests in parallel, sharing data among test steps and manage Objects using Spring Dependency Injection.

Sample tests against [Unsplash](https://unsplash.com/) web app.

## Libraries Used

* [Cucumber](https://cucumber.io/docs/cucumber/) - 7.11.1
* [Junit](https://junit.org/junit5/docs/current/user-guide/) - 5.8.2
* [Spring](https://docs.spring.io/spring-framework/docs/current/reference/html/) - 5.3.24
* [Gradle](https://gradle.org/guides) - 7.4.2
* [Selenide](https://selenide.org/documentation.html) - 5.24.2
* [Selenide wiki](https://github.com/selenide/selenide/wiki)
* [Allure](https://docs.qameta.io/allure/) - 2.19.0
* [Logback](http://logback.qos.ch/manual/index.html) - 1.2.5
* [AssertJ](https://assertj.github.io/doc/) - 3.20.2

Reference Links:
* [cucumber-junit-platform-engine](https://github.com/cucumber/cucumber-jvm/tree/main/cucumber-junit-platform-engine)
* [Cucumber 7 release notes](https://github.com/cucumber/cucumber-jvm/blob/main/release-notes/v7.0.0.md)

## Run/Debug tests

* run all tests in parallel, number of threads can be specified in RunCucumberTests.class or junit-platform.properties:
    - cucumber.execution.parallel.enabled: set to true to enable parallel execution
    - cucumber.execution.parallel.config.fixed.parallelism: integer, set number of threads
    - cucumber.execution.execution-mode.feature:
        - concurrent (scenarios are executed in parallel on any available thread)
        - same_thread (executes scenarios sequentially in the same thread as the parent feature)


  ```shell
  $ ./gradlew clean test --info
  ```


* run all tests in `firefox` browser

```shell
  $ gradlew -Dselenide.browser=firefox clean test --info
  ```

* run tests in Selenium Grid
    - enable parallel execution properties in junit-platform.properties
    - set these 2 properties in selenide.properties
        - selenide.remote.execution = true
        - selenide.remote = http://localhost:4444/wd/hub (Grid hub Url)<br>


* Debug test on IntelliJ IDE.
Run Debug RunCucumberTests.java as JUnit Test


After the tests are ran, you can see:
* logs from file appender under `build/logs/log.log`
* Allure results `build/allure-results`

## ScenarioContext

Represents test context to save/get test data and share it among test steps in one Cucumber scenario.

Example:
<code>
scenarioContext.setContext(DataItem.COLLECTION_NAME, collectionName);
</code>

<code>
String collectionName = (String) scenarioContext.getContext(DataItem.COLLECTION_NAME);
</code>

## DataStorage
Represents a storage to store test data and handle clean up after each Cucumber scenario.

Example:
<code>
dataStorage.setCollectionNames(collectionName);
</code>


## Allure reports
Allure report will contain framework logs, Selenide browser interaction logs, screenshots and page sources for
failing test cases

* [Allure CLI](https://docs.qameta.io/allure/#_commandline) should be installed
* Allure results stored in `build/allure-results`
* To generate allure report, first navigate to unsplash directory then run command:
  ```shell
  $ allure serve
  ```


## Logback configuration

You can find logback configuration here `src/test/resources/logback-test.xml`

Current configuration contains two appenders:
(default log level: INFO)

* ConsoleAppender will output logs to system out stream
* FileAppender will output logs to `build/logs/log.log`