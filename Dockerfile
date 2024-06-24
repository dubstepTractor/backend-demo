FROM docker.io/adoptopenjdk:11-jre-hotspot AS build
WORKDIR /app

RUN apt-get update && apt-get install -y maven
# Copy the Maven project and build the application
COPY pom.xml .
COPY src src
RUN mvn clean package

# Use a smaller base image for the final container
FROM docker.io/adoptopenjdk:11-jre-hotspot
WORKDIR /app

# Copy the compiled JAR file from the previous stage
COPY --from=build /app/target/your-application.jar .
EXPOSE 8080
# Start the Spring Boot application when the container launches
CMD ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar"]
