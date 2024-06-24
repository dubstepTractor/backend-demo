FROM docker.io/openjdk:17.0.2-jdk-slim-buster
ARG JAR_FILE=target/*.jar
RUN mvn clean package
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
