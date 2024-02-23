# McArthurGlen automation proof of concept

The primary objective of this POC is to showcase the ITG's ability to create front end automation framework for [Serravalle](https://www.mcarthurglen.com/it/outlets/it/designer-outlet-serravalle/)

## How to run

### Prerequisites
- JDk 17
- Maven
- Cucumber Java Plugin
- Running Docker version of the application developed(mac-poc)
- Maven Dependency installation(maven clean install)

### Ways to run the tests

There are three ways to run the test:

1. **Test Runner file:** Open the test runner file click on **Run** icon appearing in front of the class. This will run all the tests in the feature file.
2. **Feature File- Whole Suite** : Open the feature file located under feature folder. Click on **Run** icon appearing in front of the **Feature** keyword. This will run all the tests in the feature file.
3. **Feature File- Individual Test** : Open the feature file located under feature folder. Click on **Run** icon appearing in front of the **Scenario** keyword. This will run the chosen test in the feature file.

## Reports

Html report(cucumber-reports) is generated under target folder and can be opened using any browser