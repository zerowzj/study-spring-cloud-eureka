#!/bin/sh
#进入脚本目录
cd $(dirname $0)
#返回上级目录
# cd ..

#项目名称
PROJECT_NAME=study-springcloud-eureka
#JAR文件
JAR_FILE=study-springcloud-eureka-1.0.jar
#部署目录
DEPLOY_DIR=$(pwd)

#标准输出
STDOUT_LOG=/xdfapp/logs/$PROJECT_NAME/stdout.log
# GC日志
GC_LOG=/xdfapp/logs/$PROJECT_NAME/gc.log

#alias gpid="ps -ef |grep $CONF_DIR |grep $LIB_DIR |grep -v grep |awk '{print $2}'"
#pid=`gpid`
#alias psp="ps -ef |grep $CONF_DIR |grep $LIB_DIR |grep -v grep"
#shopt -s  expand_aliases
#shopt expand_aliases

#环境变量
source /etc/profile
#export JAVA_HOME=/usr/jdk1.8.0_162
#export PATH=$PATH:$JAVA_HOME/bin

#启动参数
JAVA_DEBUG_OPTS="-Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,address=8000,server=y,suspend=n "
JAVA_JMX_OPTS=" -Dcom.sun.management.jmxremote.port=13002 -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.authenticate=false "
JAVA_MEM_OPTS=" -server -Xms256m -Xmx256m -Xmn128m -Xss256k"
JAVA_GC_OPTS=" -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+PrintClassHistogram -XX:-TraceClassUnloading -verbose:gc -Xloggc:"$GC_LOG_FILE
JAVA_OPTS=$JAVA_MEM_OPTS

#获取pid
get_pid() {
  pid=$(ps -ef | grep $JAR_FILE | grep -v grep | awk '{print $2}')
  echo "$pid"
}
#启动
start() {
  echo "Starting server ..."
  pid=$(get_pid)
  if [ -n "$pid" ]; then
    echo "ERROR: Server running on $pid"
    exit 0
  fi
  nohup java $JAVA_OPTS -jar $DEPLOY_DIR/$JAR_FILE >$STDOUT_LOG 2>&1 &
  sleep 2
  pid=$(get_pid)
  if [ $? -eq 0 ]; then
    echo "STARTED PID: $pid"
  else
    echo "ERROR: Start failure![code: $?]"
  fi
  exit 0
}
#停止
stop() {
  echo "Stopping server ... "
  pid=$(get_pid)
  if [ -z "$pid" ]; then
    echo "ERROR: No server to stop!"
    return 0
  fi
  #sudo kill $pid
  /usr/bin/sudo kill -9 $pid
  if [ $? -eq 0 ]; then
    echo "STOPPED PID: $pid"
  else
    echo "ERROR: Stop failure![code: $?]"
    exit 0
  fi
}
#查看状态
status() {
  pid=$(get_pid)
  if [ -z "$pid" ]; then
    echo "No server running"
  else
    echo "Running on $pid"
  fi
  exit 0
}

#（★）入口
case $1 in
start)
  start
  ;;
stop)
  stop
  ;;
status)
  status
  ;;
restart)
  pid=$(get_pid)
  if [ -n "$pid" ]; then
    stop

  fi
  start
  ;;
*)
  echo "Usage: $0 {start|stop|restart|status}"
  exit 0
  ;;
esac
