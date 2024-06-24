# Use maven official image to build the application
FROM docker.io/maven:3.8.1-openjdk-17 AS build
WORKDIR /home/app
COPY src ./src
COPY pom.xml .
RUN mvn clean package

# Use adoptopenjdk image for Java 17 to run the application
FROM docker.io/adoptopenjdk/openjdk17:alpine-jre
WORKDIR /app
COPY --from=build /home/app/target/demo-0.0.1-SNAPSHOT.jar /app/demo.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "demo.jar"]
