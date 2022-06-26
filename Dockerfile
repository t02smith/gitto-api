FROM openjdk:17-alpine
MAINTAINER t02smith.com
VOLUME /tmp
EXPOSE 8080
EXPOSE 5432
ARG JAR_FILE=target/gitto-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} gitto-api.jar
ENTRYPOINT ["java", "-jar", "gitto-api.jar"]