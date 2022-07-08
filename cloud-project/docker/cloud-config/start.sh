#!/bin/sh
path_current="$(pwd)"

cd "${path_current}/../../../properties"
path_properties="$(pwd)"

cd "${path_current}/../../../../ssl"
path_ssl="$(pwd)"

echo "path_properties: ${path_properties}"
echo "path_ssl: ${path_ssl}"

JAVA_PATH_BIN="java"
"${JAVA_PATH_BIN}" -jar -Dcloudproject.home="${path_properties}/application" \
-Dcloudproperties.home="${path_properties}/cloud" \
-Dcloudproject.ssl.home="${path_ssl}" \
"${path_current}/cloud-config-1.0-plain.jar" &