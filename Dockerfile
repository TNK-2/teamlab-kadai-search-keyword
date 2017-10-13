FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/teamlab-spring-boot-docker-0.1.0.jar app.jar
RUN apk add --no-cache mysql-client
COPY target/wait.sh wait.sh
COPY target/mydb.sql mydb.sql
ENV JAVA_OPTS=""