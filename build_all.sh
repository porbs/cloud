#!/bin/bash

cd ./eureka-server
./build.sh
cd ../hello-service
./build.sh
cd ../user-service
./build.sh