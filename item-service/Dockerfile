FROM gradle:6.3.0-jdk8 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon
FROM openjdk:8-jdk-alpine
EXPOSE 8002
RUN mkdir -p /app/
COPY --from=build /home/gradle/src/build/libs/*.jar item-service.jar
ENTRYPOINT ["java", "-jar", "/app/item-service.jar"]