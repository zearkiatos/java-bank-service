docker_up() {
    docker compose up --build
}

docker_down() {
    docker compose down
}

podman_up() {
    podman compose up --build
}

podman_down() {
    podman compose down
}

build() {
    javac -d target ./src/main/java/org/example/Main.java
}

run() {
    java -cp target org.example.Main
}