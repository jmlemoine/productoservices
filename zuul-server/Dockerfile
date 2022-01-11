FROM gradle:6.3.0-jdk8 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon
FROM openjdk:8-jdk-alpine
EXPOSE 8090
RUN mkdir -p /app/
COPY --from=build /home/gradle/src/build/libs/*.jar zuul-server.jar
ENTRYPOINT ["java", "-jar", "/app/zuul-server.jar"]