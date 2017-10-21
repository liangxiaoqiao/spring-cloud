#!/bin/bash

function start_eureka() {
    echo 'start eureka'
    cd ./spring-eureka-server
    gradle clean build
    java -jar build/libs/spring-eureka-server-0.0.1.jar --spring.profiles.active = server1
}


function start_gradle() {
    echo 'start gradle'
}

if [ $1 = 'eureka' ]
then start_eureka
elif [ $1 = 'gradle' ]
then start_gradle
else
echo $1
echo 'Not matched'
fi





