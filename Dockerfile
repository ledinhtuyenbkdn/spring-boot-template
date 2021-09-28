FROM gradle:jdk11 AS build

COPY --chown=gradle:gradle . /home/gradle/src

WORKDIR /home/gradle/src

RUN gradle build --no-daemon

FROM openjdk:11-jre-slim

MAINTAINER ledinhtuyenbkdn

WORKDIR /var/www

COPY --from=build /home/gradle/src/build/libs/spring-boot-template-0.0.1-SNAPSHOT.jar ./app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]