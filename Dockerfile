FROM icr.io/appcafe/websphere-liberty:kernel-java8-ibmjava-ubi

USER root
RUN yum -y install unzip
USER 1001

RUN wget https://www.yourkit.com/download/docker/YourKit-JavaProfiler-2023.9-docker.zip -P /tmp/ && \
  unzip /tmp/YourKit-JavaProfiler-2023.9-docker.zip -d /usr/local && \
  rm /tmp/YourKit-JavaProfiler-2023.9-docker.zip

COPY --chown=1001:0 /src/main/liberty/config /config

RUN features.sh

COPY --chown=1001:0 build/libs/*.war /config/apps

RUN configure.sh
