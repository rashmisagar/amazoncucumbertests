# java-selenium-cucumber-tests-demo

E2E testing of Amazon website using Java, Selenium and Cucumber framework

Prerequisite - 

1. Firefox Version -  53.0.2
2. Java Version -  jdk1.8.0_121
3. Apache Maven - apache-maven-3.5.1
4. Gecko Driver Settings : Download "geckodriver.exe" from https://github.com/mozilla/geckodriver/releases
                           Set GeckoDriver local path in the script at: amazoncucumbertests/src/test/java/com/amazon/automation/tests/AmazonStepDefs.java
                           
5. Feature File Details - amazoncucumbertests/src/test/resources/feature/amazonshopcheapest.feature
6. Open command prompt and navigate to project location
7. Run maven command 

``
          mvn clean test
 ``
  
