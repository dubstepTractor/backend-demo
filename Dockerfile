FROM docker.io/openjdk:17.0.2-jdk-slim-buster AS build
WORKDIR /app
ARG JAR_FILE=target/*.jar
RUN apt-get update && apt-get install -y maven
COPY pom.xml .
COPY src src
RUN mvn package -DskipTests

FROM docker.io/openjdk:17.0.2-jdk-slim-buster
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
