# Use a base image with the desired JDK version
FROM adoptopenjdk:11-jdk-hotspot

WORKDIR /app

COPY gradlew .
COPY gradle ./gradle

RUN chmod +x ./gradlew

COPY build.gradle.kts settings.gradle.kts ./

COPY src ./src

RUN ./gradlew build

EXPOSE 8080

CMD ["java", "-jar", "build/libs/food-delivery-backend-all.jar"]
