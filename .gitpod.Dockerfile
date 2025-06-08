FROM gitpod/workspace-full


USER root

RUN apt-get update \
 && DEBIAN_FRONTEND=noninteractive apt-get install -y make \
 && apt-get clean \
 && rm -rf /var/lib/apt/lists/*

USER gitpod
RUN curl -s "https://get.sdkman.io" | bash
ENV SDKMAN_DIR="/home/gitpod/.sdkman"
ENV PATH="${SDKMAN_DIR}/bin:${SDKMAN_DIR}/candidates/java/current/bin:$PATH"

COPY makefile .
COPY .sdkmanrc .

RUN bash -c "source $HOME/.sdkman/bin/sdkman-init.sh && sdk install java 21.0.6-tem && sdk env"