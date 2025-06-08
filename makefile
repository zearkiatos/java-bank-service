docker-up:
	docker compose up --build

docker-down:
	docker compose down

podman-up:
	podman compose up --build

podman-down:
	podman compose down

build:
	javac -d target `find src/main/java -name "*.java"`

run:
	make build
	java -cp target org.example.Main

set-env:
	sdk env

install-env:
	sdk env install