FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app

COPY ./app .

RUN mvn clean package

RUN mvn package spring-boot:repackage

FROM openjdk:17-jdk-alpine
COPY --from=build /app/target/dindoepet.jar /dindoepet.jar
EXPOSE 8080

CMD ["java", "-jar", "/dindoepet.jar"]