$! /bin/bash

JAR_FILE=/app/study-springcloud-eureka-1.0.jar

JAVA_MEM_OPTS=" -server -Xms1g -Xmx2g -Xmn1g -Xss1g -XX:PermSize=128m -XX:MaxPermSize=512m"
JAVA_GC_OPTS=" -XX:+PrintGC -XX:PrintGCDetails -XX:PrintGCTime"
JAVA_OPTS=$JAVA_MEM_OPTS

case $1 in
start) ;;

stop) ;;

*)
  echo "Usage: $0{start|stop}"
  ;;
esac
