FROM openjdk:21-jdk-slim
VOLUME /tmp
COPY target/survey-management-api-1.0-SNAPSHOT.jar survey-management-api.jar
COPY config.yml config.yml
ENTRYPOINT ["java","-jar","/survey-management-api.jar","server", "config.yml"]