FROM openjdk:8-jdk-alpine
MAINTAINER Vladimir N <nva2003@yandex.ru>
ARG JAR_FILE=target/social-network.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]