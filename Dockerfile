FROM openjdk:8-jdk-alpine
VOLUME /tmp
# create directory for application
RUN mkdir /app
WORKDIR /app
#ADD target/gs-spring-boot-docker-0.1.0.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar build/libs/teamlab-spring-boot-docker-0.1.0.jar" ]
