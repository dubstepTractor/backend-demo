FROM docker.io/openjdk:17.0.2-jdk-slim-buster AS build
WORKDIR /app

# Install required packages
RUN apt-get update \
    && apt-get install -y curl gnupg2 \
    && curl -sL https://deb.nodesource.com/setup_16.x | bash - \
    && apt-get install -y maven \
    && apt-get clean \
    && rm -rf /var/lib/apt/lists/*

# Copy the project files and build the project
COPY pom.xml .
COPY src src
RUN mvn package -DskipTests

FROM docker.io/openjdk:17.0.2-jdk-slim-buster
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
