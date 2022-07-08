FROM openjdk:11

ARG path_properties
ARG path_ssl

ENV PATH_PROPERTIES=/properties
ENV PATH_SSL=/properties/ssl
ENV PATH_JAR=/otp/app
ENV server_port=8888

RUN mkdir -p /properties/spring-app
RUN mkdir -p /properties/ssl
RUN mkdir -p "${PATH_JAR}/libs"

WORKDIR "${PATH_JAR}"
COPY "cloud-config-1.0-plain.jar" "${PATH_JAR}/cloud-config.jar"
COPY "libs" "${PATH_JAR}/libs"
COPY "properties" "/properties"
COPY "ssl" "/ssl"

EXPOSE "${server_port}"
ENV JAVA_OPTS="-Dcloudproject.home=${PATH_PROPERTIES}/application -Dcloudproperties.home=${PATH_PROPERTIES}/cloud"
ENTRYPOINT exec java $JAVA_OPTS -jar cloud-config.jar
