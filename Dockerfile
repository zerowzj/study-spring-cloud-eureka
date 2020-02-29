#基础镜像
FROM frolvlad/alpine-java:jdk8-slim
#镜像作者
LABEL maintainer="wangzhj<zerowzj@163.com>" app="study-springcloud-eureka"
#
ADD Shanghai /etc/localtime
RUN echo 'Asia/Shanghai' >/etc/timezone
#
ARG JAR_FILE
ENV DEPLOY_DIR=/app \
    JAR_NAME=study-springcloud-eureka-1.0.jar
#
RUN mkdir $DEPLOY_DIR
ADD $JAR_FILE $DEPLOY_DIR
#
WORKDIR $DEPLOY_DIR
ENTRYPOINT ["sh", "-c", "java -jar $JAR_NAME"]

EXPOSE 7100