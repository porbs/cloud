#!/bin/bash

if [ "$#" -ne 1 ]; then
    echo "usage: ./run_all.sh [NUM_OF_WORKER_INSTANCES]"
    exit
fi

docker-compose up --scale worker-service=$1