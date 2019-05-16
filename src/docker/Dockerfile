FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD wsldy.jar wsldy.jar
RUN /bin/cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
   && echo 'Asia/Shanghai' >/etc/timezone \
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/wsldy.jar"]
