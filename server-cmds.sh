#!usr/bin/env bash

docker-compose -f docker-compose.yaml up --detach
echo "the process has been done successfully, dumm"
export TEST=testvalue   