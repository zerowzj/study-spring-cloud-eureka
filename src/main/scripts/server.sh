$! /bin/bash

JAR_FILE=/app/study-springcloud-eureka-1.0.jar

JAVA_MEM_OPTS=" -server -Xms512M -Xmx512M -Xmn1g -Xss1g -XX:PermSize=128m -XX:MaxPermSize=512m"
JAVA_GC_OPTS=" -XX:+PrintGC -XX:PrintGCDetails -XX:PrintGCTime"
JAVA_OPTS=$JAVA_MEM_OPTS

get_pid() {
    pid=$(ps -ef |grep $JAR_FILE |grep -v grep |awk '{ print $2 }')
    echo "$pid"
}

case $1 in
start)
  if [ -n '']; then
    nohup java $JAVA_OPTS -jar $JAR_FILE &
  fi
  ;;
stop) ;;

*)
  echo "Usage: $0{start|stop}"
  ;;
esac
