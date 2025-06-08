FROM gitpod/workspace-full


USER root

RUN apt-get update \
 && DEBIAN_FRONTEND=noninteractive apt-get install -y make \
 && apt-get clean \
 && rm -rf /var/lib/apt/lists/*

USER gitpod
RUN make install-env