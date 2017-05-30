#!/bin/bash


while getopts du:dp:bn: option
do
 case "${option}"
 in
 du) DOCKER_HUB_USR=${OPTARG};;
 dp) DOCKER_HUB_PW=${OPTARG};;
 bn) BUILD_NUMBER=${OPTARG};;
 esac
done

docker build -t klaytonwade/store-management:$BUILD_NUMBER .
docker login -u=$DOCKER_HUB_USR -p=$DOCKER_HUB_PW
docker push klaytonwade/store-management

echo "DOCKERHUB PUSH OVER"

docker ps -a | grep store-management | awk '{print $1}' | xargs docker stop
docker ps -a | grep store-management | awk '{print $1}' | xargs docker rm
docker ps -a | grep store-management | awk '{print $1}' | xargs docker rm
docker images -a | grep store-management | awk '{print $3}' | xargs docker rmi -f
docker run -d -p 8090:8080 klaytonwade/store-management:$BUILD_NUMBER
