FROM openjdk:15

#workdir
WORKDIR /usr/share/ui

#Add the jars
ADD target/selenium-ui-fw.jar   selenium-ui-fw.jar
ADD target/selenium-ui-fw-tests.jar selenium-ui-fw-tests.jar
ADD target/libs libs
ADD testng.xml  testng.xml

ENTRYPOINT java -cp selenium-ui-fw.jar:selenium-ui-fw-tests.jar:libs/* -Dbrowser=$browser org.testng.TestNG testng.xml