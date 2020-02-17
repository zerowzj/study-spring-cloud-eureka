#基础镜像
FROM frolvlad/alpine-java:jdk8-slim
#镜像作者
LABEL maintainer="wangzhj<zerowzj@163.com>" app="eureka"
#设置时区
ADD Shanghai /etc/localtime
RUN echo 'Asia/Shanghai' >/etc/timezone
#变量
ARG JAR_FILE
ARG TAR_FILE
ENV PROJECT_NAME=study-springcloud-eureka
ENV DEPLOY_DIR=/app
#
ADD ${JAR_FILE} /app/app.jar

#
ADD ${TAR_FILE} /${DEPLOY_DIR}
RUN tar -zcvf /${DEPLOY_DIR}/${TAR_FILE} /${DEPLOY_DIR}
#
WORKDIR /${DEPLOY_DIR}/bin
ENTRYPOINT ["/bin/sh", "server.sh", "start"]
#ENTRYPOINT ["java","-jar", "app.jar"]
#
#EXPOSE 7100
