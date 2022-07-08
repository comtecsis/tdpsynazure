#!/bin/sh
PID=$(ps -ef | grep cloud-config-1.0-plain.jar | grep -v grep | awk '{print $2}')
if [ -z "$PID" ]
then
    echo Application is already stopped
else
    echo kill $PID
    kill $PID
fi
