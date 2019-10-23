#!/bin/bash

JAR_FILE=/app/study-springcloud-eureka-1.0.jar

JAVA_MEM_OPTS=" -server -Xms512M -Xmx512M -Xmn1g -Xss1g -XX:PermSize=128m -XX:MaxPermSize=512m"
JAVA_GC_OPTS=" -XX:+PrintGC -XX:PrintGCDetails -XX:PrintGCTime"
JAVA_OPTS=$JAVA_MEM_OPTS

export JAVA_HOME
export PATH=$PATH:$JAVA_HOME/bin

get_pid() {
  pid=$(ps -ef | grep $JAR_FILE | grep -v grep | awk '{ print $2 }')
  echo "$pid"
}
start() {
  pid=$(get_pid)
  if [ -z "$pid" ]; then
    nohup java $JAVA_OPTS -jar $JAR_FILE &
  fi
}
stop() {
  pid=$(get_pid)
  if [ -n "$pid" ]; then
      kill -9 $pid
  fi
}

case $1 in
start)
  start
  ;;
stop)
  stop
  ;;
*)
  echo "Usage: $0 {start|stop}"
  ;;
esac
