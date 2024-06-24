# Use the official maven/Java 17 image from Docker Hub
FROM docker.io/adoptopenjdk:17-jdk-hotspot

# Set the working directory in the container
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY . /app

# Build the application
RUN mvn clean install

# Make the container's port 8080 available to the outside world
EXPOSE 8080

# Run the application using the command provided by the maven plugin
CMD ["java", "-jar", "target/demo-0.0.1-SNAPSHOT.jar"]
