# Stage 1: Build with Maven
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY ./app .
RUN mvn clean package -DskipTests
RUN mvn package spring-boot:repackage

# Stage 2: Create final image with JRE and executable jar
FROM openjdk:17-jdk-alpine3.14
COPY --from=build /app/target/dindoepet.jar /app/dindoepet.jar
EXPOSE 8080
CMD ["java", "-jar", "/app/dindoepet.jar"]