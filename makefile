docker-up:
	docker compose up --build

docker-down:
	docker compose down

podman-up:
	podman compose up --build

podman-down:
	podman compose down

build:
	javac -d target ./src/main/java/org/example/Main.java

run:
	make build
	java -cp target org.example.Main