#!/bin/sh
path_current="$(pwd)"

ecr_repo_name=local

mkdir -p "${path_current}/logs"
cd "${path_current}/logs"
path_logs="$(pwd)"

cd "${path_current}/../compile/artifacts"
path_artifacts="$(pwd)"

cd "${path_current}/api-clients"
path_api_clients="$(pwd)"

cd "${path_current}/cloud-config"
path_cloud_config="$(pwd)"

cd "${path_current}/../properties"
path_properties="$(pwd)"

cd "${path_current}/../../ssl"
path_ssl="$(pwd)"

echo "path_current: ${path_current}"
echo "path_logs: ${path_logs}"
echo "path_cloud_config: ${path_cloud_config}"
echo "path_api_clients: ${path_api_clients}"
echo "path_properties: ${path_properties}"
echo "path_ssl: ${path_ssl}"

# Compile cloud-config
cp -r "${path_artifacts}/cloud-config" "${path_current}"
mkdir -p "${path_cloud_config}/properties/application"
mkdir -p "${path_cloud_config}/properties/cloud"
cp -r "${path_properties}/application/cloud-config.properties" "${path_cloud_config}/properties/application/cloud-config.properties"
cp -r "${path_properties}/cloud/api-clients.properties" "${path_cloud_config}/properties/cloud/api-clients.properties"
mkdir -p "${path_cloud_config}/ssl"
cp -r "${path_ssl}/tdpsynopsis.p12" "${path_cloud_config}/ssl/tdpsynopsis.p12"
cp -r "${path_ssl}/project-ssl.properties" "${path_cloud_config}/ssl/project-ssl.properties"
cd "${path_cloud_config}"
docker image rm boot-cloud-config
docker build \
-t "${ecr_repo_name}/boot-cloud-config" .

# Compile api-clients
cp -r "${path_artifacts}/api-clients" "${path_current}"
mkdir -p "${path_api_clients}/properties/application"
cp -r "${path_properties}/application/api-clients.properties" "${path_api_clients}/properties/application/api-clients.properties"
mkdir -p "${path_api_clients}/ssl"
cp -r "${path_ssl}/tdpsynopsis.p12" "${path_api_clients}/ssl/tdpsynopsis.p12"
cp -r "${path_ssl}/project-ssl.properties" "${path_api_clients}/ssl/project-ssl.properties"
cd "${path_api_clients}"
docker image rm boot-api-clients
docker build \
-t "${ecr_repo_name}/boot-api-clients" .
