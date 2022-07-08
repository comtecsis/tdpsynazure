#!/bin/sh
PID=$(ps -ef | grep api-clients-1.0-plain.jar | grep -v grep | awk '{print $2}')
if [ -z "$PID" ]
then
echo Application is already stopped
else
echokill$PID
kill$PID
fi
