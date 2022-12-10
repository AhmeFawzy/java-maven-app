#!/usr/bin/env bash

export IMAGE=$1                     // $1 means the first input
export DOCKER_USER=$2               // $2 means the second input
export DOCKER_PWD=$3
echo $DOCKER_PWD | docker login -u $DOCKER_USER --password-stdin
docker-compose -f docker-compose.yaml up --detach
echo "success"


// the parameters that we defined above are from the command def shellCmd = "bash ./server-cmds.sh ${IMAGE_NAME} ${DOCKER_CREDS_USR} ${DOCKER_CREDS_PSW}"  and each one of them is the $1 $1 or $3 that we definded fahem?
// ya3ni kom parameter will to to get its value from the place its defined at 