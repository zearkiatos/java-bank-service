FROM openjdk:21
COPY . /usr/src/main
WORKDIR /usr/src/main
RUN javac -d target ./src/main/java/org/example/Main.java
CMD ["java", "-cp", "target", "org.example.Main"]