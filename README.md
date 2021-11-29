This repository contains the source code presented as part of the virtual meetup organized by The Test Tribe Community.
- [Link to the event](https://thetesttribe.com/event/the-test-tribe-6th-virtual-meetup/)

## Setup needed for running this code
- Selenium grid4 jar file [link to download](https://www.selenium.dev/documentation/grid/)
- Windows host machine with chrome browser installed
- Windows host machine with android setup (SDK and emulator)
- Appium server [link to download](https://github.com/appium/appium-desktop/releases/)

## How to start grid in hub mode
- java -jar selenium-server-jar-file  hub

## Start appium server
- appium
  
## How to start grid as node
- java -jar selenium-server-jar-file node --config tomal-config-file-for-node

Note: All the node config files are present under src/test/resources folder

## testng configuration
- Update the grid ip address in the files under testngXmls/*.xml
- Update the udid of the devices connected in the files under testngXmls/*.xml

## Selenium grid configuration
- Update the udid of the devices connected in the node toml config files under src/test/resources/*.toml 

## Run the tests
- To run the web tests use the xml file under testngXmls/webAppTests.xml
- To run the native app tests use the xml file under testngXmls/nativeAppTests.xml
