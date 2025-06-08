FROM openjdk:21-slim
COPY . /usr/src/main
WORKDIR /usr/src/main
RUN apt-get update && apt-get install -y make
RUN make build
CMD ["java", "-cp", "target", "org.example.Main"]