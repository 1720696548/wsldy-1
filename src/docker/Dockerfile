FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD wsldy.jar wsldy.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/wsldy.jar"]