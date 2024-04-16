FROM icr.io/appcafe/websphere-liberty:kernel-java8-ibmjava-ubi
LABEL org.opencontainers.image.source https://github.com/Nordic-MVP-GitOps-Repos/liberty-sampleapp

#USER root
#RUN yum -y install unzip && wget https://www.yourkit.com/download/docker/YourKit-JavaProfiler-2023.9-docker.zip -P /tmp/ && \
#  unzip /tmp/YourKit-JavaProfiler-2023.9-docker.zip "YourKit-JavaProfiler-2023.9/bin/linux-x86-64/*" -d /usr/local && \
#  rm /tmp/YourKit-JavaProfiler-2023.9-docker.zip
#USER 1001

COPY --chown=1001:0 /src/main/liberty/config /config
COPY --chown=1001:0 build/wlp/lib/wmq.jmsra-9.3.5.0.rar /liberty/lib

RUN features.sh

COPY --chown=1001:0 build/libs/*.war /config/apps

RUN configure.sh