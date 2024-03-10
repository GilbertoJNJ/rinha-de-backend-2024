FROM gradle:8.5-jdk17 as builder

COPY . /app
WORKDIR /app

RUN gradle build -x test

FROM openjdk:17

COPY --from=builder /app/build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar","app.jar"]