# Используем официальный образ OpenJDK как базовый образ
FROM openjdk:21-jdk-slim

# Устанавливаем рабочую директорию внутри контейнера
WORKDIR /app

# Копируем файл jar в рабочую директорию контейнера
COPY build/libs/Fitnes_Club-0.0.1-SNAPSHOT-plain.jar app.jar

# Устанавливаем переменную окружения для указания, что это Spring Boot приложение
ENV JAVA_OPTS="-Dspring.profiles.active=production"

# Запускаем приложение
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
