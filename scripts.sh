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

package() {
    mvn clean package
}

gradle_build() {
    gradle build
}

set_env() {
    sdk env
}

install_env() {
    sdk env install
}

test() {
    mvn test
}

install() {
    mvn clean install -U
}