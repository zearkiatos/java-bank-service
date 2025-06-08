FROM gitpod/workspace-full

RUN apt-get update && apt-get install -y make
RUN make install-env