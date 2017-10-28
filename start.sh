#!/bin/bash

function start_db() {
    echo 'start db'
    cd ./spring-db
    gradle clean build
    nohup java -jar build/libs/spring-db-0.0.1.jar  --server.port=8088 > /home/logs/spring-db-server1.log &
    nohup java -jar build/libs/spring-db-0.0.1.jar  --server.port=8089 > /home/logs/spring-db-server2.log &
    echo 'start db finish port 8088  8089'
}

function start_eureka() {
    echo 'start eureka'
    cd ./spring-eureka-server
    gradle clean build
    (nohup java -jar build/libs/spring-eureka-server-0.0.1.jar -spring.profiles.active=server1 > /home/logs/spring-eureka-server1.log &)
    (nohup java -jar build/libs/spring-eureka-server-0.0.1.jar -spring.profiles.active=server2 > /home/logs/spring-eureka-server2.log &)
    echo 'start eureka finish'
}


function start_gradle() {
    echo 'start gradle'
}


function stop(){
    process=$1
    pid=$(ps x | grep $process | grep -v grep |grep -v log| awk '{print $1}')
    for i in $pid
    do 
        kill -9 $i 
        echo '结束进程'$i
    done
}

if [ $1 = 'eureka' ]
then start_eureka
elif [ $1 = 'gradle' ]
then start_gradle
elif [ $1 = 'db' ]
then start_db
elif [ $1 = 'stop' ]
then stop $2
else
echo $1
echo 'Not matched'
fi





