FROM docker.io/openjdk:17.0.2-jdk-slim-buster

# Set the working directory
WORKDIR /app

# Update package lists and install Maven
RUN apt-get update && apt-get install -y maven

# Copy the project files to the working directory
COPY . .

# Build the Maven project
RUN mvn clean package

# Specify the JAR file
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Expose the port the application runs on
EXPOSE 8080

# Set the entry point to run the jar file
ENTRYPOINT ["java","-jar","/app.jar"]
