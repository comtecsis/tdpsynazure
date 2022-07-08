FROM openjdk:11

ARG path_properties
ARG path_ssl

ENV PATH_PROPERTIES=/properties
ENV PATH_SSL=/ssl
ENV PATH_JAR=/otp/app
ENV server_port=8080

RUN mkdir -p /properties/spring-app
RUN mkdir -p /properties/ssl
RUN mkdir -p "${PATH_JAR}/libs"

WORKDIR "${PATH_JAR}"
COPY "api-clients-1.0-plain.jar" "${PATH_JAR}/api-clients.jar"
COPY "libs" "${PATH_JAR}/libs"
COPY "properties" "/properties"
COPY "ssl" "/ssl"

EXPOSE "${server_port}"
ENV JAVA_OPTS="-Dcloudproject.home=${PATH_PROPERTIES}/application -Dcloudproject.ssl.home=${PATH_SSL}"
ENTRYPOINT exec java $JAVA_OPTS -jar api-clients.jar
