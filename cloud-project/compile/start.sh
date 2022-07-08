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

cd "${path_current}/../properties"
path_properties="$(pwd)"

cd "${path_current}/../../ssl"
path_ssl="$(pwd)"

echo "path_current: ${path_current}"
echo "path_logs: ${path_logs}"
echo "path_artifacts: ${path_artifacts}"
echo "path_cloud_config: ${path_cloud_config}"
echo "path_api_clients: ${path_api_clients}"
echo "path_properties: ${path_properties}"
echo "path_ssl: ${path_ssl}"

# Compile cloud-config
cd "${path_artifacts}/cloud-config"
java -jar -Dcloudproject.home="${path_properties}/application" \
-Dcloudproperties.home="${path_properties}/cloud" \
-Dcloudproject.ssl.home="${path_ssl}" \
"cloud-config-1.0-plain.jar" &

delay 20000

# Compile cloud-config
cd "${path_artifacts}/api-clients"
java -jar -Dcloudproject.home="${path_properties}/application" \
-Dcloudproperties.home="${path_properties}/cloud" \
-Dcloudproject.ssl.home="${path_ssl}" \
"api-clients-1.0-plain.jar" &