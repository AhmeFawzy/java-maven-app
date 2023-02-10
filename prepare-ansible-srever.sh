#!/usr/bin/env bash

apt update
apt install ansible -y   #-y to auto confirm (the prompt to type yes to continue installing it)
apt install python3-pip -y
pip3 install boto3 botocore
