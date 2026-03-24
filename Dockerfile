FROM  maven:4.0.0-eclipse-temurin-17 AS build
LABEL authors="amirdi"

WORKDIR /app

COPY pom.xml .

COPY . /app

RUN mvn package

CMD ["java", "-jar", "target/laskin.jar"]