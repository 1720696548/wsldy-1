FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD wsldy.jar wsldy.jar
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai  /etc/localtime
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/wsldy.jar"]
