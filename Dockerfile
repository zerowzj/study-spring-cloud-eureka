#基础镜像
FROM frolvlad/alpine-java:jdk8-slim
#维护人的信息
MAINTAINER wangzhj <zerowzj@163.com>
#镜像作者
LABEL maintainer=wangzhj
#
#VOLUME ["/tmp"]
#
ARG JAR_FILE
ADD ${JAR_FILE} /xdfapp
RUN rm ${JAR_FILE} app.jar
#
ADD Shanghai /etc/localtime
RUN echo 'Asia/Shanghai' >/etc/timezone
#
RUN cd /xdfapp
#
ENTRYPOINT ["java","-Djava.security. =file:/dev/./urandom","-jar","/xdfapp/app.jar"]
#
#EXPOSE 7100
