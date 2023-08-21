#!/bin/bash
#
# Run JMeter Docker image with options

NAME="jmeter"
JMETER_VERSION="latest"
IMAGE="image-path/jmeter:latest"

# Finally run
docker run --rm --name ${NAME} -i -v ${PWD}:${PWD} -w ${PWD} ${IMAGE} $@
