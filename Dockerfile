FROM openjdk:17-jdk-slim
MAINTAINER gymfit
COPY target/fit-0.0.1-SNAPSHOT.jar fit-0.0.1-SNAPSHOT.jar
ENTRYPOINT["java","-jar","fit-0.0.1-SNAPSHOT.jar"]