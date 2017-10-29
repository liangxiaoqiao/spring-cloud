#!/bin/bash

function start_db() {
    echo 'start db'
    cd ./spring-db
    gradle clean build
    nohup java -jar build/libs/spring-db-0.0.1.jar  --spring.profiles.active=local > /home/logs/db1.log &
    nohup java -jar build/libs/spring-db-0.0.1.jar  --spring.profiles.active=test > /home/logs/db2.log &
    echo 'start db finish'
}

function start_eureka() {
    echo 'start eureka'
    cd ./spring-eureka-server
    gradle clean build
    nohup java -jar build/libs/spring-eureka-server-0.0.1.jar --spring.profiles.active=server1 > /home/logs/eureka1.log &
    nohup java -jar build/libs/spring-eureka-server-0.0.1.jar --spring.profiles.active=server2 > /home/logs/eureka2.log &
    echo 'start eureka finish'
}

function start_discover(){
    echo 'start discover'
    cd ./spring-eureka-server
    gradle clean build
    nohup java -jar build/libs/spring-eureka-server-0.0.1.jar --spring.profiles.active=local > /home/logs/eureka1.log &
    echo '启动eureka注册中心'
    cd ../spring-db
    gradle clean build
    nohup java -jar build/libs/spring-db-0.0.1.jar  --spring.profiles.active=one --server.port=8090 > /home/logs/db1.log &
    nohup java -jar build/libs/spring-db-0.0.1.jar  --spring.profiles.active=one --server.port=8091 > /home/logs/db2.log &
    echo '启动两个服务提供者'
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
        echo '结束进程'$1+' 进程号：'$i
    done
}

function stop_discover(){
    stop 'eureka'
    stop 'spring-db'
}


function show(){
    process=$1
    result=$(ps x | grep $process | grep -v grep |grep -v log| awk '{print}')
    echo $result
}


if [ $2 = 'start' ]
then
    if [ $1 = 'eureka' ]
    then start_eureka
    elif [ $1 = 'gradle' ]
    then start_gradle
    elif [ $1 = 'db' ]
    then start_db
    elif [ $1 = 'discover' ]
    then start_discover
    else
    echo 'not matched'
    fi
elif [[ $2 = 'stop' ]]
then
    if [ $1 = 'discover' ]
    then stop_discover
    else stop $1
    fi
elif [[ $2 = 'show' ]]
then show $1
else
echo $1 $2
echo 'Not matched'
fi





