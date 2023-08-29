FROM openjdk:8u212-jre-alpine3.9

RUN apk add curl jq

#workspace
WORKDIR /usr/share/varad

# add .jar files from target folder from host to this image
ADD target/selenium-docker.jar  selenium-docker.jar
ADD target/selenium-docker-tests.jar  selenium-docker-tests.jar
ADD target/libs  libs
# we can add other supporting files like .csv .excel

ADD Login-module-parallel.xml  Login-module-parallel.xml
ADD Login-module-parallel2.xml  Login-module-parallel2.xml

# add health check script
ADD healthcheck.sh healthcheck.sh

#BROWSER
#HUB_HOST
#MODULE

ENTRYPOINT sh healthcheck.sh



