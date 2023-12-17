FROM maven:3.8-openjdk-8 AS build
COPY pom.xml .
RUN mvn dependency:go-offline

COPY src src

RUN mvn clean package  -Dskiptests

FROM openjdk:8-jre-slim-stretch

COPY --from=build /target/realestateplatform-0.0.1-SNAPSHOT.jar realestateplatform.jar

ENTRYPOINT [ "java","-jar","realestateplatform.jar"]