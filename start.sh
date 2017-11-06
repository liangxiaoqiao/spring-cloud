#!/bin/bash

function start_db() {
    echo 'start db'
    cd ./spring-db
    gradle clean build
    nohup java -jar build/libs/spring-db-0.0.1.jar  --spring.cloud.config.profile==local > /home/logs/db1.log &
    nohup java -jar build/libs/spring-db-0.0.1.jar  --spring.cloud.config.profile==test > /home/logs/db2.log &
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


function start_eureka_local() {
    echo 'start eureka local'
    cd ./spring-eureka-server
    gradle clean build
    nohup java -jar build/libs/spring-eureka-server-0.0.1.jar --spring.profiles.active=local > /home/logs/eureka1.log &
    echo 'start eureka local finish'
}

function start_config_server(){
    echo 'start config server'
    cd ./spring-config-server
    gradle clean build
    nohup java -jar build/libs/spring-config-server-0.0.1.jar   > /home/logs/configserver.log &
    echo 'config server finish'
}
function start_discover(){
    echo 'start discover'
    cd ./spring-eureka-server
    gradle clean build
    nohup java -jar build/libs/spring-eureka-server-0.0.1.jar --spring.profiles.active=local > /home/logs/eureka1.log &
    echo '启动eureka注册中心'
    start_db2
}

function start_db2(){
    cd ../spring-db
    gradle clean build
    nohup java -jar build/libs/spring-db-0.0.1.jar  --spring.cloud.config.profile=test > /home/logs/db1.log &
    nohup java -jar build/libs/spring-db-0.0.1.jar  --spring.cloud.config.profile=local > /home/logs/db2.log &
    echo '启动两个spring-db服务提供者'
}

function start_zuul(){
    cd ../spring-zuul
    gradle clean build
    nohup java -jar build/libs/spring-zuul-0.0.1.jar    > /home/logs/zuul.log &
    echo '启动zuul gateway'
}

function start_all(){
    echo 'start all'
    start_config_server
    start_db2
    start_zuul
    echo 'all has stated'
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

function stop_all(){
    stop 'spring-zuul'
    stop 'spring-db'
    stop 'spring-config-server'

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
    then
        if [ $3 = 'local' ]
        then start_eureka_local
        else start_eureka
        fi
    elif [ $1 = 'gradle' ]
    then start_gradle
    elif [ $1 = 'spring-db' ]
    then start_db
    elif [ $1 = 'discover' ]
    then start_discover
    elif [ $1 = 'config-server' ]
    then start_config_server
    elif [ $1 = 'all' ]
    then start_all
    else
    echo 'not matched'
    fi

elif [[ $2 = 'stop' ]]
then

    if [ $1 = 'discover' ]
    then stop_discover
    elif [ $1 = 'all' ]
    then stop_all
    else stop $1
    fi

elif [[ $2 = 'show' ]]
then show $1
else
echo $1 $2
echo 'Not matched'
fi





