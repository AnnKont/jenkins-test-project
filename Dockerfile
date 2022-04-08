FROM openjdk:10
WORKDIR /app
COPY build/libs/*.jar /app.jar
CMD ["java", "-jar", "/app.jar"]