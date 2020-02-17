#基础镜像
FROM frolvlad/alpine-java:jdk8-slim
#镜像作者
LABEL maintainer="wangzhj<zerowzj@163.com>" app="eureka"
#设置时区
ADD Shanghai /etc/localtime
RUN echo 'Asia/Shanghai' >/etc/timezone

#
ARG JAR_FILE
ADD ${JAR_FILE} /app/app.jar

ARG TAG_FILE
ADD ${TAR_FILE} /app/study-springcloud-eureka-1.0.tar.gz
#
WORKDIR /app
ENTRYPOINT ["java","-jar", "app.jar"]
#ENTRYPOINT ["java","-jar","app.jar"]
#
#EXPOSE 7100
