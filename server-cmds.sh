#!/usr/bin/env bash

export IMAGE=$1                     // $1 means the first input
export DOCKER_USER=$2               // $2 means the second input
export DOCKER_PWD=$3
echo $DOCKER_PWD | docker login -u $DOCKER_USER --password-stdin
docker-compose -f docker-compose.yaml up --detach
echo "success"
