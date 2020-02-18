#基础镜像
FROM frolvlad/alpine-java:jdk8-slim
#镜像作者
LABEL maintainer="wangzhj<zerowzj@163.com>" app="study-springcloud-eureka"
#设置时区
ADD Shanghai /etc/localtime
RUN echo 'Asia/Shanghai' >/etc/timezone
#变量
ARG TAR_FILE
ENV PROJECT_NAME=study-springcloud-eureka
ENV DEPLOY_DIR=/app
#
ADD ${TAR_FILE} ${DEPLOY_DIR}
#RUN tar -cvf /app/study-springcloud-eureka-1.0.tar.gz
#
WORKDIR ${DEPLOY_DIR}/${PROJECT_NAME}/lib
ENTRYPOINT ["java", "-jar", "study-springcloud-eureka-1.0.jar"]
#ENTRYPOINT ["/bin/sh", "server.sh", "start"]
#
#EXPOSE 7100
