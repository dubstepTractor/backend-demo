FROM docker.io/openjdk:17.0.2-jdk-slim-buster
WORKDIR /app
ARG JAR_FILE=target/*.jar
RUN apt-get update && apt-get install -y maven
RUN mvn clean package
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
