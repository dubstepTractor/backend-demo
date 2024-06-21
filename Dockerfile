# Этап сборки
FROM maven:3.8.4 as builder

# Устанавливаем рабочую директорию внутри контейнера
WORKDIR /app

# Копируем файлы с зависимостями
COPY pom.xml .
RUN mvn dependency:go-offline

# Копируем и собираем приложение
COPY src src
RUN mvn package

# Этап сборки приложения вместе с JAR файлом
FROM openjdk:latest

# Устанавливаем рабочую директорию внутри контейнера
WORKDIR /app

# Копируем собранный .jar файл из предыдущего этапа в контейнер
COPY --from=builder /app/target/your-application.jar /app

# Определяем, что приложение будет слушать порт 8080
EXPOSE 8080

# Команда для запуска приложения
CMD ["java", "-jar", "your-application.jar"]
