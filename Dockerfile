FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/teamlab-spring-boot-docker-0.1.0.jar app.jar
COPY target/wait.sh wait.sh
ENV JAVA_OPTS=""
ENTRYPOINT /wait.sh