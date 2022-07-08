#!/bin/sh
path_current="$(pwd)"

mkdir -p "${path_current}/logs"
cd "${path_current}/logs"
path_logs="$(pwd)"

mkdir -p "${path_current}/artifacts"
cd "${path_current}/artifacts"
path_artifacts="$(pwd)"

cd "${path_current}/../api-clients"
path_api_clients="$(pwd)"

cd "${path_current}/../cloud-config"
path_cloud_config="$(pwd)"

echo "path_current: ${path_current}"
echo "path_logs: ${path_logs}"
echo "path_artifacts: ${path_artifacts}"
echo "path_cloud_config: ${path_cloud_config}"
echo "path_api_clients: ${path_api_clients}"

# Compile cloud-config
mkdir -p "${path_artifacts}/cloud-config"
cd "${path_cloud_config}"
gradle clean jar
cp -r build/libs/* "${path_artifacts}/cloud-config/"

# Compile cloud-config
mkdir -p "${path_artifacts}/api-clients"
cd "${path_api_clients}"
gradle clean jar
cp -r build/libs/* "${path_artifacts}/api-clients/"