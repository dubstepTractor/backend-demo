# Use maven official image to build the application
FROM docker.io/maven:3.8.1-openjdk-17 AS build
WORKDIR /app
COPY src src
COPY pom.xml .
RUN mvn clean package
# Use Adoptium Temurin image for Java 17 to run the application
FROM docker.io/eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /home/app/target/demo-0.0.1-SNAPSHOT.jar /app/demo.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "demo.jar"]
