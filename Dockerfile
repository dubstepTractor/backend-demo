FROM docker.io/maven:3.8.1-openjdk-17 AS build
WORKDIR /app
COPY src src
COPY pom.xml .
RUN mvn clean install

FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
COPY --from=build /app/target/demo-0.0.1-SNAPSHOT.jar /app/demo.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "demo.jar"]
